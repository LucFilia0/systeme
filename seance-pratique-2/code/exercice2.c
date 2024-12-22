#include <string.h>
#include <unistd.h>
#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char **argv) {
	
	if(argc < 2) {
		printf("Frr, faut rentrer un nom de fichier quand même...\n");
	} else {
		char *file_name = argv[1];
		int fd = open(file_name, O_RDONLY);
		if(fd < 0) {
			perror("Erreur open");
		}
		char data;
		int retour;
		while((retour = read(fd, &data, 1)) > 0) {
			write(1, &data, 1);
		}
	}
	return 0;
}
