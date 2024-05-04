PROGRAM NumericalIntegration

! Purpose: This code utilizes the Monte Carlo method to compute the value of an
! integral of a particular function with particular boundaries, and then
! compares the value of that integral with values of the same integral calculated 
! using the trapezoidal rule and Simpson's rule. 
!
! History:
!       Version        Programmer      Date     Description/Comments
!       ------          -------         --      -------------------
!          1          Jacob Archer  02/19/2024  Code created from scratch
!
! Input:
!       Quantity        Units           Description
!       -------         -----           ----------
!         k             number         initial index for summation
!         N             number         number of final term in summation
!      a, b             numbers        integral bounds
!        f_k            number         function of k
!        h              number         width of trapezoid
!       add             number         current value of sum
!       f, x            numbers        components of function f(x)
!
!
! Output:
!       Quantity        Units           Description
!       -------         -----           ----------
!        a, b          numbers          integral bounds
!        N             number           number of trapezoids
!        h             number           trapezoid width
!
! SPECIAL REQUESTS: NONE

IMPLICIT NONE

REAL :: a, b, h, x_k, f, x, add, trap, fTerm1
INTEGER :: n, k

f(x) = x**(5.0/2.0) * COSH(x)**2 * EXP(-(x)**(0.5) * COS(x) - (x**3) * SIN(x**2)**2) * (1.0+(0.5*x)+(0.2*x**2)+(0.1*x**4))**(-5)

write(*,*) 'Input integration boundaries a, b:'
read(*,*) a, b

nLoop: DO n=2, 100, 2
  h = (b-a) / n
  add = 0.0
  intLoop: DO k=1, n-1
            x_k = a + h*k
            add = add + f(x_k)
           END DO intLoop
       trap = h * (f(a) + f(b) + (2.0 * add)) / 2
       write(*,*) 'N=', n, 'Value of Integral=', trap, 'a=', a, 'b=', b
       
       END DO nLoop

END PROGRAM NumericalIntegration