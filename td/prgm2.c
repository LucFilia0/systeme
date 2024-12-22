#include <unistd.h>
#include <stdio.h>

int main(int argc, char **argv) {

	int rt = fork();

	if(rt > 0) {
		for(int i = 0; i < 100; ++i) {
			printf("1 : %d\n", i);
		}
	} else {
		for(int i = 0; i < 100; ++i) {
			printf("2 : %d\n", i);
		}
	}
	
	printf("Fin");
	return 0;
}
