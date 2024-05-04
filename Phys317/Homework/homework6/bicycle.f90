Program Bicycle
! Purpose: This code uses the Euler forward method to compute the distance, speed, 
! and pedal force of a bicycle racer for the first 200 seconds of a race, i.e., 0 < t ≤ 200 s, 
! and show the results graphically in three different plots.
!
! History:
!   Version      Programmer         Date            Description/Comments
!   -------      ----------         -----           ---------------------
!      1         Jacob Archer      03/13/2024       Code created from scratch

IMPLICIT NONE

REAL :: f_ped, f_air, f_roll, m, t_d, f_0, f_avg, p, a, c_d, c_r, g, t, x, v, dv, dist, speed, delta_t
Integer:: i

! Open output files
OPEN(unit=10, file='distance.dat', status='unknown')
OPEN(unit=20, file='speed.dat', status='unknown')
OPEN(unit=30, file='pedal_force.dat', status='unknown')

! Define Variables
m = 70.0
t_d = 35.0
f_0 = 200.0
f_avg = 50.0
p = 1.2
a = 0.4
c_d = 0.07
c_r = 0.01
g = 9.81
x = 0.0
v = 0.0
delta_t = 0.01

! Create loop to calculate values of equation
mainLoop: DO  i = 0, 20000
    t = float(i)*0.01
    
    IF(0.0 <=t .AND. t<60.0) THEN
        f_ped = f_avg + (f_0 - f_avg)*EXP(-t/t_d)
    
    ELSE IF (80.0<t .AND. t<=200.0) THEN
        f_ped = f_avg + (f_0 - f_avg)*EXP(-t/t_d)
        
    ELSE
        f_ped = 77.17
    
    END IF
    
    dv = (f_ped - f_air - f_roll) * delta_t
    
    WRITE(10,*) t, x
    WRITE(20,*) t, v
    WRITE(30,*) t, f_ped
    
    v = v + dv
    x = x + v
    f_air  = 0.5 * p * a * c_d * v**2
    f_roll = c_r * m * g
    
   END DO mainLoop

close(unit=10)
close(unit=20)
close(unit=30)

END PROGRAM Bicycle
