PROGRAM FourierSine

! Purpose: This code computes the The Fourier sine transform of a function f(t) and compares
! the value of this result with the result derived from an analytical method.
!
! History:
!       Version        Programmer      Date     Description/Comments
!       ------          -------         --      -------------------
!          1          Jacob Archer  02/26/2024  Code created from scratch
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
!       f, t            numbers        components of function f(t)
!        f_b            number         constant in function f(t)
!
!
! Output:
!       Quantity        Units           Description
!       -------         -----           ----------
!         N             number         number of final term in summation
!      a, b             numbers        integral bounds
!        u_a            number         function of k
!        u_b              number         width of trapezoid
!        M             number         current value of sum
!
! SPECIAL REQUESTS: NONE

IMPLICIT NONE

REAL :: a, b, h, add, f_k, f, t, trap, f_b, w, ft_b
INTEGER :: n, i, j, k

f(t) = EXP(-ft_b * t) * SIN(w*t)

OPEN(unit=10, file='FourierTrNum.dat', status='unknown')
OPEN(unit=20, file='FourierTrExact.dat', status='unknown')

a=0.0
b=3.0
n=100

ft_b = 2.0

omega: DO i=0, 300
     w = i / 30.0
     f_b = (w / (w**2 + 4))
      outerLoop: DO j=0, n
            h = (b-a) / n
            add = 0.0
             innerLoop: DO k=1, n-1
                 f_k = a + h*k
                 add = add + f(f_k)
              END DO innerLoop
       trap = h * (f(a) + f(b) + (2.0 * add)) / 2
      END DO outerLoop
    WRITE(10, *) w, trap
    WRITE(20, *) w, f_b
  END DO omega
  
END PROGRAM FourierSine
       