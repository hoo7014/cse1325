#include <string>
#ifndef _COLOR_H
#define _COLOR_H

using namespace std;
class Color {
	int red;
	int green;
	int blue;
	bool reset;
     public:
    	Color();
   	Color(int r, int g, int b);
	std::string to_string();
	std::string colorize(std::string text);
	friend ostream& operator<<(ostream& ost, Color C);
};
#endif
