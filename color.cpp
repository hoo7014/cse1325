#include "color.h"
#include <iostream>
Color:: Color(int r, int g, int b){
	red=r;
	green=g;
	blue=b;
}
std::string Color::to_string(){
	std::string s="(";
	s.append(std::to_string(red));
	s.append(",");
	s.append(std::to_string(green));
	s.append(",");
	s.append(std::to_string(blue));
	s.append(")");
	return(s);
}
std::string Color::colorize(std::string text) {
	std::string s1="\033[38;2;";
	s1.append(std::to_string(red));
	s1.append(";");
	s1.append(std::to_string(green));
	s1.append(";");
	s1.append(std::to_string(blue));
	s1.append("m");
	s1.append(text);
	s1.append("\033[0m");
	return(s1);
}	
