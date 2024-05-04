PROGRAM Pesticides

! This program computes the amount of pesticide in your body, P(t), as a function
! of time, assuming you eat one apple per day for 2 years, i.e., 0 ≤ t ≤ T (with T = 2 years), 
! and that you have no pesticide in your body at t = 0. This value will be calculated 
! using a first-order differential equation that will be solved using Euler’s forward 
! differentiation method. The results will be presented graphically.
!
! History:
!       Version        Programmer      Date     Description/Comments
!       ------          -------         --      -------------------
!          1          Jacob Archer  03/04/2024  Code created from scratch
!
! SPECIAL REQUESTS: NONE

IMPLICIT NONE

REAL :: t_f, t, p, lambda1, lambda2, alpha, a, sig, step, p_0, d_p, heavy
INTEGER :: i, j, k 

OPEN(unit=10, file='pesticides.dat', status='unknown')

WRITE(*,*) 'Enter time step (delta t) and final time in years (T):'
READ(*,*) step, t_f

! Define variables
lambda1 = 0.01
lambda2 = 0.03
alpha = 0.000001
a = 1.0
sig = a*alpha
p_0=0.0

pFunction: DO i=0, int((t_f*365.0)/step)
             t = i*step
             WRITE(10,*) t, p_0
             heavySide: IF (t <= 365.0) THEN
                 heavy = 0.0
                 ELSE 
                 heavy = 1.0
                 END IF heavySide
                  
             d_p = (sig - (3.0/4.0)*lambda1*p_0 - (1.0/4.0)*heavy*lambda2*p_0)*step
             p_0 = p_0 + d_p
           END DO pFunction
CLOSE(unit=10)

END PROGRAM Pesticides