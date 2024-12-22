#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main(int argc, char **argv) {

        int i, retourExit, retourFork = 1, pid;

        printf("Le shell a pour PID %d\n", getppid());

        for(i = 0; i < 3; ++i) {
                retourFork = fork();
                printf("Mon PID est %d, mon père est %d et i=%d\n", getpid(), getppid(), i);
        }

        while( (pid = wait(&retourExit)) > 0) {
                printf("Code de retour du fils %d : %d\n", pid, WEXITSTATUS(retourExit));

        }

        return i;
}
