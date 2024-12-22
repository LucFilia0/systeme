#include <stdio.h>
#include <unistd.h>

int main(int argc, char **argv) {

	int x = 100;
	int retourFork;

	printf("Coucou !\n");
	retourFork = fork();

	if(retourFork > 0) {
		++x;
		printf("Je suis le père, x=%d\n", x);
	} else {
		--x;
		printf("Je suis le fils, x=%d\n", x);
	}
	printf("Exécuté par les deux ! x=%d\n", x);

	return 0;
}
