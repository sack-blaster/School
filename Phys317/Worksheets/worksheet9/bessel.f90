PROGRAM Bessel

    IMPLICIT NONE
    
    REAL :: x, j_x, j_x2
    INTEGER :: k, n, i
    
    OPEN(unit=10, file='Bessel_J0_J6/Bessel_0.dat', status='unknown')
    OPEN(unit=20, file='Bessel_J0_J6/Bessel_1.dat', status='unknown')
    OPEN(unit=30, file='Bessel_J0_J6/Bessel_2.dat', status='unknown')
    OPEN(unit=40, file='Bessel_J0_J6/Bessel_3.dat', status='unknown')
    OPEN(unit=50, file='Bessel_J0_J6/Bessel_4.dat', status='unknown')
    OPEN(unit=60, file='Bessel_J0_J6/Bessel_5.dat', status='unknown')
    OPEN(unit=70, file='Bessel_J0_J6/Bessel_6.dat', status='unknown')
    OPEN(unit=80, file='Bessel2_J0_J6/BesselOut.dat', status='unknown')
    OPEN(unit=90, file='Bessel2_J0_J6/BesselOut1.dat', status='unknown')
    OPEN(unit=100, file='Bessel2_J0_J6/BesselOut2.dat', status='unknown')
    OPEN(unit=110, file='Bessel2_J0_J6/BesselOut3.dat', status='unknown')
    OPEN(unit=120, file='Bessel2_J0_J6/BesselOut4.dat', status='unknown')
    OPEN(unit=130, file='Bessel2_J0_J6/BesselOut5.dat', status='unknown')
    OPEN(unit=140, file='Bessel2_J0_J6/BesselOut6.dat', status='unknown')
    
    n=201    ! n=number of lines of data
    outer: DO k=1, n
      inner: DO i=0, 60, 10
              READ(i+10,*) x, j_x
              j_x2 = j_x**2
              WRITE(i+80,*) x, j_x2
             END DO inner
           END DO outer
           
    CLOSE(unit=10)
    CLOSE(unit=20)
    CLOSE(unit=30)
    CLOSE(unit=40)
    CLOSE(unit=50)
    CLOSE(unit=60)
    CLOSE(unit=70)
    CLOSE(unit=80)
    CLOSE(unit=90)
    CLOSE(unit=100)
    CLOSE(unit=110)
    CLOSE(unit=120)
    CLOSE(unit=130)
    CLOSE(unit=140)
    
END PROGRAM Bessel
   
    
       