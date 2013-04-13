/*#include "inc/lm4f120h5qr.h"
#include "inc/hw_memmap.h"
#include "inc/hw_types.h"
#include "driverlib/debug.h"
#include "driverlib/fpu.h"
#include "driverlib/gpio.h"
#include "driverlib/pin_map.h"
#include "driverlib/rom.h"
#include "driverlib/sysctl.h"
#include "utils/uartstdio.h"
#include "driverlib/systick.h"*/

#define C1		523
#define C1s		554
#define D1f		554
#define D1		587
#define D1s		622
#define E1f		622
#define E1		659
#define F1		698
#define F1s		740
#define G1f		740
#define G1		784
#define G1s		831
#define A1b		831
#define A1		880
#define A1s		932
#define B1f		932
#define B1		988
#define C2		1047
#define C2s		1109
#define D2f		1109
#define D2		1175
#define E2s		1245
#define F2f		1245
#define E2		1319
#define F2		1397
#define F2s		1480
#define G2f		1480
#define G2		1568
#define G2s		1661
#define A2f		1661
#define A2		1760
#define A2s		1865
#define B2f		1865
#define B2		1976
#define C3		2093
#define REST	200000
#define END		400000

// int song[16][2] = {{C1,2},{D1,1},{E1,1},{F1,1},{G1,1},{A1,1},{B1,1},{C2,2},{D2,1},{E2,1},{F2,1},{G2,1},{A2,1},{B2,1},{C3,2},{REST,4}};
// int song[42][2] = {{C1,1},{C1,1},{G1,1},{G1,1},{A1,1},{A1,1},{G1,2},{F1,1},{F1,1},{E1,1},{E1,1},{D1,1},{D1,1},{C1,2},{G1,1},{G1,1},{F1,1},{F1,1},{E1,1},{E1,1},{D1,2},{G1,1},{G1,1},{F1,1},{F1,1},{E1,1},{E1,1},{D1,2},{C1,1},{C1,1},{G1,1},{G1,1},{A1,1},{A1,1},{G1,2},{F1,1},{F1,1},{E1,1},{E1,1},{D1,1},{D1,1},{C1,2}};*/
/*int song[42][2] = {{C2,1},{C2,1},{G2,1},{G2,1},{A2,1},{A2,1},{G2,2},
										{F2,1},{F2,1},{E2,1},{E2,1},{D2,1},{D2,1},{C2,2},
										{G2,1},{G2,1},{F2,1},{F2,1},{E2,1},{E2,1},{D2,2},
										{G2,1},{G2,1},{F2,1},{F2,1},{E2,1},{E2,1},{D2,2},
										{C2,1},{C2,1},{G2,1},{G2,1},{A2,1},{A2,1},{G2,2},
										{F2,1},{F2,1},{E2,1},{E2,1},{D2,1},{D2,1},{C2,2}};*/
										
int song[47][2] = {{REST,0},{E2,192},{REST,0},{F2,192},{REST,0},{G2,384},{REST,0},{C2,192},{REST,0},{B1,192},{REST,0},{C2,384},{REST,0},{C3,384},{REST,0},{B2,384},{REST,0},{A2,192},{REST,0},{B2,192},{REST,0},{G2,384},{REST,0},{D2,192},{REST,0},{E2,192},{REST,0},{F2,384},{REST,0},{B1,192},{REST,0},{A1,192},{REST,0},{B1,384},{REST,0},{G2,384},{REST,0},{F2,192},{REST,0},{E2,192},{REST,0},{D2,192},{REST,0},{E2,192},{REST,0},{C2,384},{END,0}};

									
										