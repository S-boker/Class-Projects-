#include <iostream>
#include <cmath>
using namespace std;

bool ok(int a[], int n) {
   for(int i = 0; i < n; ++i)
      if ((a[i] == a[n]) || (abs(a[i] - a[n]) == n - i)) return false;       
   return true;
}

int main(){
   int count = 0,c = 0, q[8] = {0}, i, j, k, l; 
   typedef char box[5][7];
   box bb, wb, *board[8][8];
   box bq = { {char(219),char(219),char(219),char(219),char(219),char(219),char(219)}, {char(219),' ',char(219),' ',char(219),' ' ,char(219)},{char(219),' ',' ',' ',' ',' ',char(219)}, {char(219),' ',' ',' ',' ',' ',char(219)},{char(219),char(219),char(219),char(219),char(219),char(219),char(219)} };                  
   box wq = { {' ',' ',' ',' ',' ' ,' ',' '}, {' ',char(219),' ',char(219),' ',char(219),' '}, {' ',char(219),char(219),char(219),char(219),char(219),' ' }, {' ',char(219),char(219),char(219),char(219),char(219),' '},{' ' ,' ' ,' ',' ',' ' ,' ' ,' '} };
   while(true){
     c++;
     q[c] = -1;
     if(c==8){
       for(i=0; i<5; i++)
          for(j=0; j<7; j++) {
             bb[i][j] = ' ';
             wb[i][j] = char(219);
          }
       for(i=0; i<8; i++)
          for(j=0; j<8; j++)
             if((i+j)%2 == 0) board[i][j] = &wb;
             else board[i][j] = &bb;
       for(i = 0; i <8; i++)
          if((q[i] + i)%2== 0) board[q[i]][i] = &wq;
          else board[q[i]][i] = &bq;
       cout <<"Solution #" <<++count <<endl;  
       for(i=0; i<7*8; i++) cout << '_';
       cout <<endl;
       for(i=0; i<8; i++) 
          for(k=0; k<5; k++) {  
             cout << char(179);
             for(j=0; j<8; j++)    
                for(l=0; l<7; l++) cout << (*board[i][j])[k][l];
                   cout << char(179) <<endl;
          }    
          cout << " ";
          for(i=0; i<7*8; i++) cout << char(196);
          cout <<endl;
          c--;
          if(c == -1) return 0;
     }
     while(q[c] < 8){
        q[c]++;
        if(q[c] == 8){
          c--;
          if(c == -1) return 0;
        }
        else if(ok(q,c)) break;
     }
   } 
}
