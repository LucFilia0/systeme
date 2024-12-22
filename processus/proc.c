#include <stdlib.h>
#include <unistd.h>
#include <sys/resource.h>
#include <sys/time.h>

int main(int argc, char** argv)
{
	int prio_fils = atoi(argv[1]);
	int prio_pere = atoi(argv[2]);

	char c;

	if(fork() > 0)
	{
		// Père
		setpriority(PRIO_PROCESS, 0, prio_fils);
		c = 'P';
	}
	else
	{
		// Fils
		setpriority(PRIO_PROCESS, 0, prio_pere);
		c = 'F';
	}
	for(int i = 0; i < 1000; ++i)
	{
		write(1, &c, 1);
	}

	return 0;
}
