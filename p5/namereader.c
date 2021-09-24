#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
int main (int argc, char *arv[]) 
{
char name[15];
int fd, n;

	if (access ("fifo", F_OK) == -1) /*doesn’t exist */
 	if (mknod("fifo", 010600, 0) == 0)
 	printf("Named Pipe created successfully \n");
	 else {
	 printf("Failed to create Named Pipe \n");
	 exit(0); /* Program terminates */
	 }
 	else
 	printf("Using existing named pipe \n");

	fd = open("fifo", O_RDONLY);

	n = read (fd, name, 15);

	name[n] = (char) 0;
	
	printf("%s read from pipe fifo", name);
}
