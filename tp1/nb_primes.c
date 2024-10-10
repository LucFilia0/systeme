#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>


int is_prime(int n) {
	if (n < 2) return 0;
	if (n==2) return 1;
	for (int i = 2 ; i*i <= n ; i++) {
		if (n%i==0) 
			return 0;
	}
	return 1;
}

int nb_primes(int debut, int fin) {
	int res = 0;
		for (int i = debut ; i < fin ; i++) {
			if (is_prime(i)) {
				res++;
			}
		}
		return res;	
}

int main(int argc, char** argv) {
	if (argc != 2) {
		printf("Merci de renseigner la borne supérieure en paramètre\n");
		return 0;
	}
	int n = atoi(argv[1]);
	int fork1 = -1;
	int fork2 = -1;

	!!! ICI UN TRAVAIL AVEC DES FORKS ET LES VARIABLES fork1 fork2 !!!
	
	
	if ( !!! ICI LA CONDITION POUR ÊTRE LE PROCESSUS PÈRE !!!) {
		//pere
		int nb_primes = 0;
		int retour;
		while (wait(&retour)>0) {
			printf("L'un des fils a retourné %d\n", WEXITSTATUS(retour));
			nb_primes += WEXITSTATUS(retour);
		}
		printf("au total : %d nombres premiers\n", nb_primes);
	} else {
		//l'un des deux fils
		if ( !!! CONDITION FILS 1 !!!) {
			debut = 0;
			fin = n/2;
		} else {
			debut = n/2;
			fin = n;
		}
		printf("début de la recherche de %d à %d par pid%d\n", debut, fin, getpid());
		return nb_primes(debut, fin);
	}
	return 0;
}

