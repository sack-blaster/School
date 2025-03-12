PROGRAM NonLinearMotion

! Purpose: The position (in meters) of a certain physical object for a specified
! time interval based on a predefined equation. This equatino involves an integral,
! which will be calculated using the trapezoidal rule.
!
! History:
!       Version        Programmer      Date     Description/Comments
!       ------          -------         --      -------------------
!          1          Jacob Archer  02/28/2024  Code created from scratch
!
! Input:
!       Quantity        Units           Description
!       -------         -----           ----------
!         k             number         initial index for summation
!         N             number         number of final term in summation
!        a, b           numbers        integral bounds
!        w_k            number         function of k
!        h              number         width of trapezoid
!        add            number         current value of sum
!        w, t           numbers        components of function f(t)
!        alpha          number         constant in function x(t)
!
!
! Output:
!       Quantity        Units           Description
!       -------         -----           ----------
!        t              number         time
!        x_t            meters         position of object
!
! SPECIAL REQUESTS: NONE

IMPLICIT NONE

REAL, PARAMETER :: pi=ACOS(-1.0)
REAL :: a, b, h, add, w_k, x_t, t, trap, alpha, w
INTEGER :: n, i, j, k

w(t) = EXP((-alpha**2)*SQRT((t/5.0))) * SIN(t)**2 * COS(pi*SQRT(t))**2 * SQRT(t)

OPEN(unit=10, file='xvst.dat', status='unknown')

a=0.0
b=10.0
alpha=2.5

WRITE(*,*) 'Enter number of grid points N:'
READ(*,*) n

omega: DO i=0, 1000
     t = i / 100.0
      outerLoop: DO j=0, n
            h = (b-a) / n
            add = 0.0
             innerLoop: DO k=1, n-1
                 w_k = a + h*k
                 add = add + w(w_k)
              END DO innerLoop
       trap = h * (w(a) + w(b) + (2.0 * add)) / 2
       x_t = (pi**3 * COS(alpha*t)**2) * trap     
      END DO outerLoop
    WRITE(*,*) 't= ', t, 'seconds', 'x(t)= ', x_t, 'meters'
    WRITE(10, *) 't= ', t, 'seconds', 'x(t)= ', x_t, 'meters'
  END DO omega
  
END PROGRAM NonLinearMotion
 