//*****************************************************************************
//
// Caitlin Miller 2013
//
//*****************************************************************************

#include "inc/lm4f120h5qr.h"
#include "inc/hw_memmap.h"
#include "inc/hw_types.h"
#include "driverlib/debug.h"
#include "driverlib/fpu.h"
#include "driverlib/gpio.h"
#include "driverlib/pin_map.h"
#include "driverlib/rom.h"
#include "driverlib/sysctl.h"
#include "utils/uartstdio.h"
#include "driverlib/systick.h"
#include "driverlib/adc.h"

#include "music.h"

unsigned long ulADC0_Value[1];

void play(void);
void piezoInput(void);
void pollFlute(void);

//*****************************************************************************
//
// The error routine that is called if the driver library encounters an error.
//
//*****************************************************************************

#ifdef DEBUG
void
__error__(char *pcFilename, unsigned long ulLine)
{
}
#endif

//*****************************************************************************
//
// SysTick Handler - creates sound across pin by writing a square wave at 
// a given frequency
//
//*****************************************************************************

void SysTickIntHandler(void){
	
	static int toggled = 0;

	// Toggle the output to the pin to create a square wave
	// This can be improved by outputting a sine wave
	// I plan to include this update later
	if(toggled == 0){
		GPIOPinWrite(GPIO_PORTD_BASE, GPIO_PIN_2, GPIO_PIN_2);
		toggled = 1;
	}
	else{
		GPIOPinWrite(GPIO_PORTD_BASE, GPIO_PIN_2, 0);
		toggled=0;
	}
	
}
	
//*****************************************************************************
//
// Music Player for Stellaris Launchpad LM4F120
//
//*****************************************************************************

int
main(void)
{
	
    // Enable lazy stacking for interrupt handlers.  This allows floating-point
    // instructions to be used within interrupt handlers, but at the expense of
    // extra stack usage.
    ROM_FPULazyStackingEnable();

    // Set the clocking to run directly from the crystal.
    ROM_SysCtlClockSet(SYSCTL_SYSDIV_4 | SYSCTL_USE_PLL | SYSCTL_XTAL_16MHZ |
                       SYSCTL_OSC_MAIN);

    ROM_SysCtlPeripheralEnable(SYSCTL_PERIPH_GPIOD);
	  ROM_SysCtlPeripheralEnable(SYSCTL_PERIPH_GPIOE);
	ROM_SysCtlPeripheralEnable(SYSCTL_PERIPH_GPIOF);
	ROM_SysCtlPeripheralEnable(SYSCTL_PERIPH_GPIOB);
	ROM_SysCtlPeripheralEnable(SYSCTL_PERIPH_GPIOA);

    ROM_GPIOPinTypeGPIOOutput(GPIO_PORTD_BASE, GPIO_PIN_2);
		ROM_GPIOPinTypeGPIOInput(GPIO_PORTE_BASE, GPIO_PIN_1);
	
	  // Initialize the LEDs	
	//ROM_GPIOPinTypeGPIOInput(GPIO_PORTF_BASE, GPIO_PIN_2);
	
		// Initialize the Switches
		ROM_GPIOPinTypeGPIOOutput(GPIO_PORTB_BASE, GPIO_PIN_2);
		ROM_GPIOPinTypeGPIOOutput(GPIO_PORTF_BASE, GPIO_PIN_0);
		ROM_GPIOPinTypeGPIOOutput(GPIO_PORTB_BASE, GPIO_PIN_7);
		ROM_GPIOPinTypeGPIOOutput(GPIO_PORTB_BASE, GPIO_PIN_6);
		ROM_GPIOPinTypeGPIOOutput(GPIO_PORTA_BASE, GPIO_PIN_4);
		ROM_GPIOPinTypeGPIOOutput(GPIO_PORTA_BASE, GPIO_PIN_3);
		ROM_GPIOPinTypeGPIOOutput(GPIO_PORTA_BASE, GPIO_PIN_2);
		ROM_GPIOPinTypeGPIOOutput(GPIO_PORTF_BASE, GPIO_PIN_4);
		

    // Initialize the UART.
    ROM_SysCtlPeripheralEnable(SYSCTL_PERIPH_GPIOA);
    ROM_GPIOPinConfigure(GPIO_PA0_U0RX);
    ROM_GPIOPinConfigure(GPIO_PA1_U0TX);
    ROM_GPIOPinTypeUART(GPIO_PORTA_BASE, GPIO_PIN_0 | GPIO_PIN_1);
    UARTStdioInit(0);

		// Initialize SysTick for sound
		SysTickDisable();
		SysTickPeriodSet(SysCtlClockGet() / 3200);
		SysTickIntRegister(&SysTickIntHandler);
		SysTickEnable();
		ROM_IntMasterEnable();
		SysTickIntEnable();
		
		// Initialize ADC
		SysCtlPeripheralEnable(SYSCTL_PERIPH_ADC0);
		SysCtlPeripheralEnable(SYSCTL_PERIPH_GPIOE);
		GPIOPinTypeADC(GPIO_PORTE_BASE, GPIO_PIN_3);
		ADCSequenceConfigure(ADC0_BASE, 3, ADC_TRIGGER_PROCESSOR, 0);
		ADCSequenceStepConfigure(ADC0_BASE, 3, 0, ADC_CTL_CH0 | ADC_CTL_IE | ADC_CTL_END);
		ADCSequenceEnable(ADC0_BASE, 3);
		ADCIntClear(ADC0_BASE, 3);

		
		// Determine if a note is being played
		
		while(1){
		GPIOPinWrite(GPIO_PORTD_BASE, GPIO_PIN_7, GPIO_PIN_7);
		GPIOPinWrite(GPIO_PORTB_BASE, GPIO_PIN_2, GPIO_PIN_2);
		GPIOPinWrite(GPIO_PORTF_BASE, GPIO_PIN_0, GPIO_PIN_0);
		GPIOPinWrite(GPIO_PORTB_BASE, GPIO_PIN_7, GPIO_PIN_7);
		GPIOPinWrite(GPIO_PORTB_BASE, GPIO_PIN_6, GPIO_PIN_6);
		GPIOPinWrite(GPIO_PORTA_BASE, GPIO_PIN_4, GPIO_PIN_4);
		GPIOPinWrite(GPIO_PORTA_BASE, GPIO_PIN_3, GPIO_PIN_3);
		GPIOPinWrite(GPIO_PORTA_BASE, GPIO_PIN_2, GPIO_PIN_2);
		GPIOPinWrite(GPIO_PORTF_BASE, GPIO_PIN_4, GPIO_PIN_4);
	}
		
		// If the note is correct, play and move on

}

void play(void){
		int i;
		for(i = 0; i < 42; i++){
			SysTickPeriodSet(SysCtlClockGet() / song[i][0]);
			SysCtlDelay(3000000*song[i][1]);
			SysTickPeriodSet(SysCtlClockGet() / REST);
			SysCtlDelay(100000);
		}
		
		return;
}

void piezoInput(void){

		ADCProcessorTrigger(ADC0_BASE, 3);
		while(!ADCIntStatus(ADC0_BASE, 3, false)){
		}
		ADCIntClear(ADC0_BASE, 3);
		ADCSequenceDataGet(ADC0_BASE, 3, ulADC0_Value);
		
		UARTprintf("%f", ulADC0_Value[0]);

		SysCtlDelay(SysCtlClockGet() / 12);
		
		return;
}
	 



