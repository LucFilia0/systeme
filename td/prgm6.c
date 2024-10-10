#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main(int argc, char **argv) {

        printf("Coucou, ici mon programme\n");

        if(fork() > 0) {
                //Père
                int retourFils;
                wait(&retourFils);

                printf("Le LS a terminé. Code de retour : %d\n", WEXITSTATUS(retourFils));
        } else {
                //Fils
                char *cmd[] = {"ls", "-l", NULL};

                execvp(cmd[0], cmd);
        }

        //printf("Ici, nous sommes après le execvp\n");

        return 0;
}
