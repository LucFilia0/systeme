#include <string.h>
#include <unistd.h>
#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char **argv) {
	int fd = open("toto.txt", O_RDONLY);
	if(fd < 0) {
		perror("Erreur open");
	}
	char data;
	int retour;
	while((retour = read(fd, &data, 1)) > 0) {
		write(1, &data, 1);
	}
	return 0;
}
