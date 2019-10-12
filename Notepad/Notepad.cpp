 

#include "stdafx.h"
#include <iostream>
#include <conio.h>
#include <windows.h>
#include <fstream>
#include <string>


using namespace std;

// Node

struct node
{
 char letter;
 node*next;
 node*prev;
 node*up;
 node*down;
};

// Cursor Movement Function

void gotoxy(int x, int y)
{
 COORD coord;
 coord.X = x; coord.Y = y;
 SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), coord);
}

// Cursor Class

class Cursor {
private:
 int x, y;
public:
 Cursor() {
 x = y = 0;
 }
 void Up() {
 y--;
 }
 void Down() {
 y++;
 }
 void Left() {
 x--;
 }
 void Right() {
 x++;
 }
 void setcursor()
 {
 gotoxy(x, y);
 }
};

// Class

class TwoDDLLADT
{
 node * first, *cursor;

public:

 void insert(char c, Cursor &T);
 void Print();
 void Save();
 void Load();
 char Delete(Cursor &T); //delete a character wherever the pointer cursor is pointing.
 void Delete(Cursor &T,char a[],int &hold);

 void Up(Cursor &T);
 void Down(Cursor &T);
 void Left(Cursor &T);
 void Right(Cursor &T); // functions control the movement of the pointer

 void CurUp(Cursor &T);
 void CurDown(Cursor &T);
 void CurLeft(Cursor &T);
 void CurRight(Cursor &T);
 //cursor
 void clear();
 //Constructor / destructor

 TwoDDLLADT();

 ~TwoDDLLADT();
};


// Class Functions


void TwoDDLLADT::Up(Cursor &T) {
 if (first == 0 || cursor->up == 0)
 return;
 cursor = cursor->up;
 T.Up();
}
void TwoDDLLADT::Down(Cursor &T) {
 if (first == 0 || cursor->down == 0)
 return;
 cursor = cursor->down;
 T.Down();
}
void TwoDDLLADT::Left(Cursor &T) {
 if (first == 0 || cursor->prev == 0)
 return;
 cursor = cursor->prev;
 T.Left();
}
void TwoDDLLADT::Right(Cursor &T) {
 if (first == 0 || cursor->next == 0)
 return;
 cursor = cursor->next;
 T.Right();
}


void TwoDDLLADT::CurUp(Cursor &T) {
 if (first == 0)
 return;
 node *temp = cursor;
 while (temp->up == 0) {
 temp = temp->prev;
 if (temp == 0)
 break;
 }
 if (temp == cursor) {
 cursor = cursor->up;
 T.Up();
 }
 else if (temp == 0)
 return;
 else {
 while (cursor->up == 0) {
 Left(T);
 }
 Up(T);
 }
}
void TwoDDLLADT::CurDown(Cursor &T) {
 if (first == 0)
 return;
 if (cursor->down != 0) {
 Down(T);
 return;
 }
 else {
 node *temp = cursor;
 while (temp->prev != 0) {
 temp = temp->prev;
 }
 if (temp->down != 0) {
 while (cursor->prev != 0) {
 Left(T);
 }
 Down(T);
 }
 }
}
void TwoDDLLADT::CurLeft(Cursor &T) {
 if (first == 0)
 return;
 if (cursor->prev == 0) {
 if (cursor->up != 0) {
 Up(T);
 while (cursor->next != 0)
 Right(T);
 }
 }
 else
 Left(T);
}
void TwoDDLLADT::CurRight(Cursor &T) {
 if (first == 0)
 return;
 if (cursor->next == 0) {
 node *temp = cursor;
 while (temp->prev != 0)
 temp = temp->prev;
 if (temp->down != 0) {
 while (cursor->prev != 0)
 Left(T);
 Down(T);
 }
 }
 else
 Right(T);
}



void TwoDDLLADT::insert(char c, Cursor &T) {

 if (first == 0) {
 first = new node();
 first->down = first->next = first->prev = first->up = 0;
 first->letter = c;
 if (c != '\r') {
 node *temp = new node;
 temp->down = temp->next = temp->prev = temp->up = 0;
 first->next = temp;
 temp->prev = first;
 temp->letter = '\0';
 cursor = first;
 Right(T);
 }
 else {
 node *temp = new node;
 temp->down = temp->next = temp->prev = temp->up = 0;
 first->down = temp;
 temp->up = first;
 temp->letter = '\0';
 cursor = first;
 Down(T);
 }
 }
 else {
 {

 node *temp = cursor;
 if (temp != 0)
 while (temp->next != 0)
 temp = temp->next;

 node *temp1 = new node;
 temp1->down = temp1->next = temp1->prev = temp1->up = 0;
 temp1->letter = '\0';

 temp->next = temp1;
 temp1->prev = temp;

 if (temp->up != 0) {
 temp1->up = temp->up->next;
 if (temp->up->next != 0)
 temp->up->next->down = temp1;
 }

 if (temp->down != 0) {
 temp1->down = temp->down->next;
 if (temp->down->next != 0)
 temp->down->next->up = temp1;
 }


 while (temp1 != cursor)
 {
 temp1->letter = temp->letter;
 temp = temp->prev;
 temp1 = temp1->prev;
 }


 temp1->letter = c;


 if (c != '\r')
 Right(T);

 if (c == '\r') {

 if (cursor->prev == 0) {

 node *up = cursor->up;

 node *upper = up;

 node *down = cursor->down;

 node *downer = down;

 node *cur = cursor;

 node *current = cursor;

 node *state = cursor->next;

 node *states = cursor->next;

 current->next->prev = 0;
 current->next = 0;

 while (up != 0) {
 up->down = 0;
 up = up->next;
 }

 while (states != 0) {
 states->up = 0;
 states = states->next;
 }

 while (cur != 0) {
 cur->up = 0;
 cur = cur->next;
 }

 if (upper != 0) {
 upper->down = current;
 }

 if (state != 0) {
 state->up = current;
 }

 current->up = upper;
 current->down = state;

 while (down != 0) {
 down->up = 0;
 down = down->next;
 }

 while (state != 0 || downer != 0) {

 if (state != 0) {
 state->down = downer;
 }
 if (downer != 0) {
 downer->up = state;
 }
 if (state != 0) {
 state = state->next;
 }
 if (downer != 0) {
 downer = downer->next;
 }

 }


 Down(T);
 return;
 }
 else {
 Right(T);
 node *current = cursor;
 node *up = current->up;
 node *down = current->down;
 node *scur = current;
 node *scurf = current;
 node *downf = cursor;

 while (downf->prev != 0) {
 downf = downf->prev;
 }
 downf = downf->down;

 while (scurf->prev != 0) {
 Left(T);
 scurf = scurf->prev;
 }

 if (current->prev != 0) {
 current->prev->next = 0;
 current->prev = 0;
 }

 if (down != 0)
 while (down->prev != 0)
 down = down->prev;

 node *curf = scurf;
 node *cur = scur;

 while (up != 0) {
 up->down = 0;
 up = up->next;
 }

 while (curf != 0 || cur != 0) {

 if (curf != 0)
 curf->down = cur;
 if (cur != 0)
 cur->up = curf;
 if (curf != 0)
 curf = curf->next;
 if (cur != 0)
 cur = cur->next;

 }

 cur = scur;

 while (down != 0 || cur != 0) {

 if (down != 0)
 down->up = cur;
 if (cur != 0)
 cur->down = down;
 if (down != 0)
 down = down->next;
 if (cur != 0)
 cur = cur->next;

 }

 while (downf != 0 || scur != 0) {

 if (downf != 0)
 downf->up = scur;
 if (scur != 0)
 scur->down = downf;
 if (downf != 0)
 downf = downf->next;
 if (scur != 0)
 scur = scur->next;

 }



 Down(T);


 }
 }
 }
 }
}

void TwoDDLLADT::Print() {

 node *row = first;
 node *col = first;

 while (row != 0) {

 while (col != 0) {

 if (col->letter != '\r')
 cout << col->letter;
 else
 cout << endl;
 col = col->next;

 }

 row = row->down;
 col = row;

 }

}

char TwoDDLLADT::Delete(Cursor &T) {

 char cc = '\0';

 if (first == 0)
 return cc;

 if (cursor == first)
 return cc;

 if (cursor->prev != 0)
 cc = cursor->prev->letter;

 if (first->next == cursor && cursor->next == 0 && first->down == 0) {
 node *temp = cursor;
 Left(T);
 delete first;
 delete temp;
 first = cursor = 0;
 return cc;
 }

 if (cursor->prev == 0) {
 node *up = cursor->up;
 node *down = cursor->down;
 node *cur = cursor;
 Up(T);

 node *sup = up;
 node *sdown = down;
 node *scur = cursor;
 node *upper = up->up;

 while (sup->next != 0) {
 Right(T);
 sup = sup->next;
 }

 sup->next = cur;
 cur->prev = sup;

 while (cur != 0) {
 sup->letter = cur->letter;
 sup = sup->next;
 cur = cur->next;
 }

 sup->prev->next = 0;
 delete sup;

 while (up != 0 || down != 0) {
 if (up != 0)
 up->down = down;
 if (down != 0)
 down->up = up;
 if (up != 0)
 up = up->next;
 if (down != 0)
 down = down->next;
 }

 while (upper != 0 || scur != 0) {
 if (upper != 0)
 upper->down = scur;
 if (scur != 0)
 scur->up = upper;
 if (upper != 0)
 upper = upper->next;
 if (scur != 0)
 scur = scur->next;
 }

 }
 else {
 node *cur = cursor;
 node *pre = cursor->prev;

 while (cur != 0) {
 pre->letter = cur->letter;
 pre = pre->next;
 cur = cur->next;
 }

 Left(T);
 pre->prev->next = 0;
 if (pre->up != 0) {
 pre->up->down = 0;
 }
 if (pre->down != 0) {
 pre->down->up = 0;
 }

 delete pre;
 }

 return cc;
}

TwoDDLLADT::TwoDDLLADT() {
 first = cursor = 0;
}

TwoDDLLADT::~TwoDDLLADT() {

clear();

}

void TwoDDLLADT::clear() {

 node *row = first;
 node *col = first;
 node *pre = first;

 while (row != 0) {

 col = row;
 row = row->down;

 while (col != 0) {

 pre = col;
 col = col->next;
 delete pre;

 }

 }
 first=cursor=0;

}

void TwoDDLLADT::Save() {
 ofstream myfile("text.txt");
 char c;

 node *row = first;
 node *col = first;

 while (row != 0) {

 while (col != 0) {

 if (col->letter != '\r')
 c = col->letter;
 else
 c = '\n';
 myfile << c;
 col = col->next;

 }

 row = row->down;
 col = row;

 }

 myfile.close();
}

void TwoDDLLADT::Load() {
 fstream myfile("text.txt");
 string c;
 if (!myfile.is_open())
 return;

 Cursor T;

 clear();

 char temp;

 while (getline(myfile, c))
 {
 for (int i = 0; i < c.size(); i++) {
 temp = c[i];
 this->insert(temp, T);
 }
 this->insert('\r', T);
 }

 cursor = first;

 myfile.close();

}

void TwoDDLLADT::Delete(Cursor &T, char a[], int &hold) {

 if (first == 0)
 return;

 node *temp = cursor;
 int check = 0;
 char c = '\0';

 while (1) {
 c = _getch();
 if (c == -32)
 {
 c = _getch();

 if (c == 115 && cursor->prev != 0) {
 CurLeft(T);
 check--;
 }
 else if (c == 116 && cursor->next != 0) {
 CurRight(T);
 check++;
 }
 }
 else
 break;
 T.setcursor();
 }

 if (check > 0) {
 node *temp2 = cursor;
 hold = 0;
 while (cursor->prev != temp)
 CurLeft(T);
 int i = 0;
 while (i != check) {
 c = Delete(T);
 a[hold] = c;
 hold++;
 i++;
 Right(T);
 }
 a[hold] = '\0';
 return;
 }
 else if (check < 0) {

 node *temp2 = cursor;
 hold = 0;
 int i = 0;
 CurRight(T);
 while (i != check) {
 c = Delete(T);
 a[hold] = c;
 hold++;
 i--;
 CurRight(T);
 }
 a[hold] = '\0';
 return;
 }
 else {
 hold = 0;
 a[hold] = '\0';
 return;
 }

}


int main()
{
 TwoDDLLADT notepad;

 Cursor Cur;

 char arr[50];
 int hold = 0;
 arr[hold] = '\0';



 while (1) {
 char c = _getch();
 if (c == -32)
 {
 c = _getch();
 if (c == 115 || c == 116)
 goto cut;
 if (c == 'H')
 notepad.CurUp(Cur);
 if (c == 'K')
 notepad.CurLeft(Cur);
 if (c == 'M')
 notepad.CurRight(Cur);
 if (c == 'P')
 notepad.CurDown(Cur);
 if (c == 'S')
 notepad.Delete(Cur);
 }
 //else if c is delete or backspace
 else if (c == 8)
 notepad.Delete(Cur);

 //else if c is S for save
 else if (c == 'S')
 notepad.Save();

 //else if c is L for load
 else if (c == 'L')
 notepad.Load();

 //else if c is Q for load
 else if (c == 'Q' || c == 27)
 break;
 else if (c == 'X') {
 cut:
 notepad.Delete(Cur, arr, hold);
 }
 else if (c == 16) {
 if (hold != 0) {
 int x = 0;
 while (arr[x] != '\0') {
 char t = arr[x];
 if (t == '\n')
 t = '\r';
 notepad.insert(t, Cur);
 x++;
 }
 }
 }
 else
 notepad.insert(c, Cur);
 system("cls");
 notepad.Print();
 Cur.setcursor();
 }
 system("pause");
}
