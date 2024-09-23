//Ruben Bautista
//CECS 326 - Summer 2024

#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

int main(int argc, char *argv[]){
	//Starts clock for runtime measurement
	clock_t begin = clock();

	//Enforces 3 arguments for terminal execution
	if(argc != 3){
		printf("Please enter only 2 text file arguments in this format './filecopy source_file dest_file' \n");
		return -1;
	}
	
	pid_t pid;
	int fd[2];

	//Creates the pipe
	if (pipe (fd)){
		fprintf (stderr, "Pipe failed.\n");
		return -1;
	}


	//Creates child process
	pid = fork();

	//If there is a parent processes, then Child process begins
	if (pid == (pid_t) 0){
		//Closes other end of pipe and initializes variables
		close (fd[1]);
		FILE *read_from_pipe;
		FILE *out_file;
		char str[100];

		//Opens pipe as "Read" and opens destination file as "Write"
		read_from_pipe = fdopen(fd[0], "r");
		out_file = fopen(argv[2], "w");

		//Copies characters from pipe to destination file
		while(fgets(str, 100, read_from_pipe) != NULL){
			fprintf(out_file, "%s", str);
		}

		//Closes out pipe and dest file
		fclose(read_from_pipe);
		fclose(out_file);

		return 0;
	}

	//If there are no parent processes then there cannot be a child
	else if (pid < (pid_t) 0){
		fprintf (stderr, "Fork failed.\n");
		return -1;
	}

	//Parent process is created
	else{
		//Other end of pipe is closed and variables are initialized
		close (fd[0]);
		FILE *read_to_pipe;
		FILE *in_file;
		char str[100];

		//Pipe is opened as "Write", Source file is opened as "Read"
		read_to_pipe = fdopen(fd[1], "w");
		in_file = fopen(argv[1], "r");

		//If the Source file does not exist it throws error
		if (in_file == NULL){
			printf("Error: Unable to open source file ");
			printf("'%s' \n", argv[1]);
			return -1;
		}

		//Copies characters from source file to pipe	
		while(fgets(str, 100, in_file) != NULL){
			fprintf(read_to_pipe, "%s", str);
		}

		//Closes pipe and source file
		fclose(read_to_pipe);
		fclose(in_file);

		//Ends clock and outputs runtime measurement
		clock_t end = clock();
		double time_spent = (double)(end - begin) / CLOCKS_PER_SEC;
		printf("%f seconds to execute \n", time_spent);
		
		return 0;
	}
	return 0;
}
