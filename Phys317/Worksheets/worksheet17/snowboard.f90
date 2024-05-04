PROGRAM Snowboard

IMPLICIT NONE

REAL :: alpha, theta, beta, g, v_0, d, v_b, hmax, t_ab, xAB, x_ab, a_deg

g = 9.81
v_b = 19.0
d = 7.0
beta = 0.314159
theta  = 0.10472
alpha = 1.5708 - beta - theta
a_deg = 66.0
v_0 = SQRT(v_b**2 - (2.0*g*d*sin(alpha))/cos(theta))
hmax = (v_0**2 * sin(alpha)**2) / (2.0*g)
t_ab = ((v_0*cos(alpha)) * (tan(alpha) + tan(beta))) / (g/2.0)
x_ab = xAB(alpha, beta, g, v_0)

WRITE(*,10) t_ab
10 FORMAT ('Airborne time: t_AB=', X, F4.2, X, 'seconds')
WRITE(*,20) hmax
20 FORMAT ('Maximum height reached: h_max=', X, F5.2, X, 'meters')
WRITE(*,30) x_ab
30 FORMAT ('Distance traveled along half-pipe: x_AB=', X, F5.2, X, 'meters')
WRITE(*,40) v_0
40 FORMAT ('Takeoff speed: v_0=', X, F5.2, X, 'meters/second')
WRITE(*,50) a_deg
50 FORMAT ('Takeoff angle: alpha=', X, F5.2, X, 'degrees')


END PROGRAM Snowboard

FUNCTION xAB(a, b, g, v_0)
IMPLICIT NONE
REAL :: a, b, g, v_0, xAB

xAB = ((v_0**2 * cos(a)**2) / ((g/2.0)*cos(b))) * (tan(a) + tan(b))

END FUNCTION xAB