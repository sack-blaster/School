PROGRAM DoLoopSums

! Purpose: This code computes the values of several different particular summations
! up to a defined number of terms N.
!
! History:
!       Version        Programmer      Date     Description/Comments
!       ------          -------         --      -------------------
!          1          Jacob Archer  02/12/2024  Code created from scratch
!
! Input:
!       Quantity        Units           Description
!       -------         -----           ----------
!       i, j, k         numbers        initial index for each summation
!         N             number        number of final term in summation
!      a, b, c, d       summation      summation equations
!        delta          number         relative deviation
!         pi            number         constant pi
!      add, prod        number         initial value of summation
!
!
! Output:
!       Quantity        Units           Description
!       -------         -----           ----------
!      a, b, c, d       numbers         result of each correspondong summation
!        delta          number         relative deviation
!
! SPECIAL REQUESTS: NONE

IMPLICIT NONE

REAL, PARAMETER :: pi=ACOS(-1.0)
REAL :: i, j, k, n, a, b, c, d, add_a, add_c, add_d, prod

sums: DO n=100, 500, 100
     add_a=0
      asum: DO i=1, n
        aInner: DO j=1, i
                add_a = add_a + 1.0 / (j**2 * (i+1.0)**2)
               END DO aInner
        END DO asum
       a = (120.0 * add_a)**0.25
       PRINT*, "N=", n, "A_N=", a, "(A_N-pi)/pi =", ABS(a-pi)/pi
       
     prod = 1
      bsum: DO k=1, n-1
           prod = prod * ((2*k)**2) / ((2*k-1.0)*(2*k+1.0))
          END DO bsum
       b=2.0*prod
       PRINT*, "N=", n, "B_N=", b, "(B_N-pi)/pi =", ABS(b-pi)/pi
       
      add_c=0
        csum: DO k=0, n
              add_c = add_c + ((k+1) / ((2*k+1)**2 * (2*k+3)))
             END DO csum
         c=(32.0 * (add_c - (1.0/8.0)))**0.5
      PRINT*, "N=", n, "C_N=", c, "(C_N-pi)/pi =", ABS(c-pi)/pi
      
      add_d=0
        dsum: DO i=1, n
           dsum2: DO j=1, n
             dsum3: DO k=1, n
                 add_d = add_d + 1.0/(i*j*k)**2
              END DO dsum3
            END DO dsum2
          END DO dsum
       d=(216.0 * add_d)**(1.0/6.0)
      PRINT*, "N=", n, "D_N=", d, "(D_N-pi)/pi =", ABS(d-pi)/pi
      
    END DO sums
    
END PROGRAM DoLoopSums
         
         
           
         
    
            