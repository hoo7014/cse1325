#include <iostream>
#include <fstream>
#include <cstdlib>
#include "color.h"
using namespace std;
int main(int argc, char* argv[]){
    std::fstream newfile;
    int r,g,b;
    if (argc!=2) cout<<"Filename to be given as argument"<<endl;
    else
    {
    	newfile.open(argv[1],ios::in);
    	string line;
    	srand(1000);
    	while(getline(newfile, line))
   	{
        	r=rand()%256;
        	g=rand()%256;
        	b=rand()%256;
        	Color C(r,g,b);
        	cout<<C.colorize(line)<<endl;
    	}
      	newfile.close(); 
    	return(0);
    }
}
