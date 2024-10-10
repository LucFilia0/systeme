#include <stdio.h>
#include <unistd.h>

int main(int argc, char **argv) {

        int rf = fork();

        switch(rf) {
                case -1 :
                        printf("Erreur");
                        break;
                case 0 :
                        sleep(2);
                        printf("Processus fils terminé\n");
                        break;
                default :
                        printf("Processus père terminé\n");
                        break;
        }
        return 0;
}
