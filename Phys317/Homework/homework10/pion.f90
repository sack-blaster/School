! The GZK (Greisen-Zatsepin-Kuzmin) cutoff is an upper limit on the energy of 
! cosmic rays that can propagate over long distances through the universe without 
! significant attenuation due to interactions with photons of the cosmic 
! microwave background radiation. This program uses Newton’s numerical root 
! finding method to determine the pion mass m_pi from a given equation.
!
! History:
!       Version        Programmer      Date     Description/Comments
!       ------          -------         --      -------------------
!          1          Jacob Archer  04/17/2024  Code created from scratch
!
! SPECIAL REQUESTS: NONE

Program Pion

IMPLICIT NONE

! Define variables
REAL :: e_p, m_pi, m_n, e_gam, m_p, diff, f_mp, fp_mp, m_pi1, epsi, gamma, v_c
REAL, PARAMETER :: pi = ACOS(-1.0)
INTEGER :: n, i

e_p = 3e+14
m_n = 940.6
m_p = 938.27
e_gam = 0.000000000233
epsi = 0.00005
n = 50

! Get user input
write(*,'(A)', advance='NO') "Enter intital guess value (m_pi): "
READ(*,*) m_pi

! Create loop to find root of function
root: DO i=1, n
    m_pi1 = m_pi - f_mp(m_pi, m_n, e_p, e_gam)/fp_mp(m_pi, m_n, e_gam)
    diff = ABS(m_pi1 - m_pi)
    WRITE(*,*) 'it = ', i, ' Delta = ', diff, ' m_pion = ', m_pi1
    IF (diff <= epsi) goto 1000 ! End loop at this point
    IF (i==n) WRITE(*,*) 'Root not found -> calculation terminated' ! Account for errors
    m_pi = m_pi1
END DO root

1000 continue

! Compute and output Lorentz factor and speed of protons
gamma = e_p/m_p + 1.0
v_c = SQRT(1.0 - (1/gamma**2))

WRITE(*,*) 'The Lorentz factor of the protons is : ', gamma
WRITE(*,*) 'The speed of the protons v/c is: ', v_c

END PROGRAM Pion

! Define f(m_pi)
FUNCTION f_mp(m_pi, m_n, e_p, e_gam)
IMPLICIT NONE
REAL, INTENT(IN) :: m_pi, m_n, e_p, e_gam
REAL :: f_mp

f_mp = e_p - (((m_n*m_pi)*(1+m_pi/(2*m_n)))/(2*e_gam))

END FUNCTION f_mp

! Define f'(m_pi)
FUNCTION fp_mp(m_pi, m_n, e_gam)
IMPLICIT NONE
REAL, INTENT(IN) :: m_pi, m_n, e_gam
REAL :: fp_mp

fp_mp = -((m_n+m_pi)/(2*e_gam))

END FUNCTION fp_mp

