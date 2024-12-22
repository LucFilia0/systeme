#include <sys/wait.h>
#include <unistd.h>
#include <stdio.h>
#include "ligne_commande.h"
#include <stdlib.h>
#include <stdbool.h>

int main(int argc, char **argv) {

	printf("Coucou, voici le shell de Luc le Manifik");

	bool fini = false;

	while(!fini) {

		printf(">>>");
		fflush(stdout);

		char **commande = lis_ligne();

		if(commande == NULL) {
			printf("So long");
			fini = true;
		} else {
			if(commande != NULL) {

				if(fork() > 0) {
					//père

					printf("Attente de la terminaison du fils");
					int retour_fils;
					wait(&retour_fils);
				} else {
					//fils
					execvp(commande[0], commande);
					printf("Le programme demandé n'existe pas");
				}
			}
		}
	}
	return 0;
}
