#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <math.h>
#include<string.h>
#include<ctype.h>

typedef struct strx {

 int side;

} Cube;

int getV(Cube z);

int main() {

Cube x;

x.side=4;

printf("%d", getV(x));

system("pause");

return 0;

}

int getV(Cube z) {

return pow(z.side, 3);

}