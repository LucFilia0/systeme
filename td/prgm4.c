#include <stdio.h>
#include <unistd.h>

int main(int argc, char **argv) {

        if(fork() > 0) {
                //père
                sleep(30);
        } else {
                //fils
                return 0;
        }

        return 0;
}
