#include <bits/stdc++.h>
using namespace std;

int main () {

    
    double x1;
    double y1;
    double x2;
    double y2;

    cin >> x1;
    cin >> y1;
    cin >> x2;
    cin >> y2;

    cout<<"A("<<x1<<y1<<")";
    cout<<"B("<<x2<<y2<<")";

    cout<<"AB="<<sqrt(pow(x1-x2,2.0)+pow(y1-y2,2.0));

    return 0;
}