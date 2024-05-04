PROGRAM Economic

! In this homework assignment, we explore the dynamics of a basic economic demand-and-supply 
! model, en-capsulated in a differential equation framework. This model elucidates the 
! relationship between the price P (t), supply S(t), and demand D(t) of a commodity over 
! time. By studying the interplay of these variables, we aim to explore the mechanisms 
! that drive price fluctuations in markets.
!
! History:
!       Version        Programmer      Date     Description/Comments
!       ------          -------         --      -------------------
!          1          Jacob Archer  03/20/2024  Code created from scratch
!
! SPECIAL REQUESTS: NONE

IMPLICIT NONE

REAL :: t, delta_t, a, b, c, alpha, k, p_0, d_t, s_t, t_max, p_t1, p_t2, p_t
INTEGER :: i, j

! Open output files
OPEN(unit=10, file='P_t.dat', status='unknown')
OPEN(unit=20, file='D_t.dat', status='unknown')
OPEN(unit=30, file='S_t.dat', status='unknown')
OPEN(unit=40, file='P_analytic.dat', status='unknown')

! Define variables
delta_t = 0.01
a = 3.67
b = 0.066
c = 2.03
alpha = 0.77
k = 5.5
p_0 = 1.0
t = 0.0
t_max = 40.0
d_t = a - b*p_0
s_t = c * (1 - cos(alpha*t))
p_t1 = (p_0 - ((a-c)/b) - ((k**2 * b*c)/(k**2 * b**2 + alpha**2))) * EXP(-k*b*t)
p_t2 = ((a-c)/b) + ((k*c)/(k**2 * b**2 + alpha**2)) * (k*b*cos(alpha*t) + alpha*sin(alpha*t))
p_t = p_t1 + p_t2

! Loop to compute P(t) numerically and compare with analytical result
DO WHILE (t <= t_max)
    WRITE(10,*) t, p_0
    WRITE(20,*) t, d_t
    WRITE(30,*) t, s_t
    WRITE(40,*) t, p_t
    p_0 = p_0 + k*(d_t - s_t)*delta_t
    d_t = a - b*p_0
    s_t = c * (1 - cos(alpha*t))
    p_t1 = (p_0 - ((a-c)/b) - ((k**2 * b*c)/(k**2 * b**2 + alpha**2))) * EXP(-k*b*t)
    p_t2 = ((a-c)/b) + ((k*c)/(k**2 * b**2 + alpha**2)) * (k*b*cos(alpha*t) + alpha*sin(alpha*t))
    p_t = p_t1 + p_t2
    t = t + delta_t
END DO

CLOSE (unit=10)
CLOSE (unit=20)
CLOSE (unit=30)
CLOSE (unit=40)

END PROGRAM Economic


