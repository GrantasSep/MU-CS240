#include <stdio.h>
#include <unistd.h>
int main()
{
	char buffer[14]="Hello World\n\n";
	write(2, buffer, 13);
}
