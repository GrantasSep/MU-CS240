#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>
int main()
{
	char buffer[20];
	int fd, n;

	fd = open("p3a.c",O_RDONLY); // a new entry is made in the descriptor table pointing to 	the newly opened file.

	n = read(fd, buffer, 18); // read from the opened file

	close(fd); // close the file and delete the entry in the descriptor table for it

	printf("%d characters were read from file p3a.c\n", n);
	printf("The characters were\n");
	write(1, buffer, n);
	printf("\n");
}
