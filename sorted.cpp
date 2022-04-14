#include <vector>
#include <fstream>
using namespace std;

int main() {
    vector<string> name ;
    fstream file_txt;

    file_txt.open("foo.txt",ios::in); //open a file to perform read operation
   if (file_txt.is_open()){ //checking whether the file is open
      string tmp;
      while(getline(file_txt, tmp)){//read data from file object and put it into tmp string.
        if(!tmp.empty()) // check if line is empty.
            name.push_back(tmp); // add the text to vector object
      }
   }
   file_txt.close(); //close the file object.
  sort(name.begin(),name.end());

  for (int i = 0; i < name.size(); i++) {
        cout << name[i] <<endl;
    }

	return 0;
}
