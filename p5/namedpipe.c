#include <fcntl.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>
#include <unistd.h>
#include <sys/stat.h>
int main(int argc, char *argv[]) {
 int namedpipe;
 int max_size = 20;
 char message[max_size+1];
 char buffer[max_size+1];
 bool paramerror= false;
/* Check for existence of named pipe and create it if it
 doesn’t exist */
if (access ("my_pipe", F_OK) == -1) /*doesn’t exist */
 if (mknod("my_pipe", 010600, 0) == 0)
 printf("Named Pipe created successfully \n");
 else {
 printf("Failed to create Named Pipe \n");
 exit(0); /* Program terminates */
 }
 else
 printf("Using existing named pipe \n");

/* Check command line parameter count, it should be 2.
 Check 2nd parameter is either “reader” or “writer” and open
 the pipe accordingly */
if (argc == 2) {
 if (strcmp (argv[1], "reader")==0)
 namedpipe = open("my_pipe", O_RDONLY);
 else if (strcmp(argv[1], "writer")==0)
 namedpipe = open("my_pipe", O_WRONLY);
 else
 paramerror = true;
 }
 else
 paramerror = true;
 if (paramerror)
 printf("Incorrect usage: Use namedpipe <reader | writer> \n");
 else if (namedpipe<0)
 printf("Couldn't open named pipe\n");

/* else if there are no command line errors or pipe opening errors then
 do the reader writer actions */
else
{ /* If we get as far as here, the pipe is open and ready */
 /* Now do reader or writer actions next */
 int i;
 if (strcmp(argv[1], "writer")==0)
 /*Writer outputs 10 messages to pipe */
 for (i=1; i<=10; i++) {
 /* The sprintf function produces formatted output like
 printf except it puts it into the string message
 Convert i to string as part of message */
 sprintf(message, "%d", i);
 /* next we add out message text to the number */
 strcat(message, " message text");
 /* now write “n message text” to the namedpipe */
 write(namedpipe, message, strlen(message));
 printf("writer: Sent message <%s> to named pipe\n",message);
 }
 else for (i=1; i<=10; i++) {
 /* Reader will read 10 times from pipe */
 int n = read(namedpipe, buffer, max_size);
 buffer[n]=0;
 printf("reader: Read message <%s> %d characters \n",buffer, n);
 }
 close(namedpipe);
}

}
