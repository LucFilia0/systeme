#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>

int main(int argc, char **argv) {

	int retour1 = fork();
	if (retour1 == 0) {
		if(fork() > 0) {
			printf("Processus A\n");
		} else {
			printf("Processus B\n");
		}
	} else {
		printf("Processus C\n");
	}
	return 0;
}
