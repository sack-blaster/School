Program DecayChain
    IMPLICIT NONE

    ! Initialize variables
    REAL :: na_0, nb_0, nc_0, nd_0, const_a, const_b, const_c, const_d
    REAL :: t, delta_t, t_max, na_1, nb_1, nc_1, nd_1

    ! Open data file
    OPEN(UNIT=10, FILE='RadioactiveDecayChain.dat', STATUS='UNKNOWN')

    ! Call subroutine to get user input
    CALL GetInput(const_a, const_b, const_c, const_d, delta_t)

    ! Define initial conditions
    t_max = 50.0
    t = 0.0
    na_0 = 1000.0
    nb_0 = 0.0
    nc_0 = 0.0
    nd_0 = 0.0
    
    ! Do loop to solve equations
    DO WHILE (t < t_max)
        WRITE(10,*) na_0, nb_0, nc_0, nd_0
        na_1 = (-const_a * na_0) * delta_t
        nb_1 = (const_a * na_0 - const_b * nb_0) * delta_t
        nc_1 = (const_b * nb_0 - const_c * nc_0) * delta_t
        nd_1 = (const_c * nc_0 - const_d * nd_0) * delta_t
        na_0 = na_1
        nb_0 = nb_1
        nc_0 = nc_1
        nd_0 = nd_1
        t = t + delta_t
    END DO

    ! Close data file
    CLOSE(UNIT=10)

    End Program DecayChain

    ! Subroutine to get user inputted data
    SUBROUTINE GetInput(const_a, const_b, const_c, const_d, delta_t)
        IMPLICIT NONE
        REAL, INTENT(OUT) :: const_a, const_b, const_c, const_d, delta_t

        ! Get user input for decay constants using advance=NO
        WRITE(*, '(A)', advance='NO') 'Enter decay constants for a, b, c, and d: '
        READ(*,*) const_a, const_b, const_c, const_d
        WRITE(*,*) 'Enter the time step: '
        READ(*,*) delta_t
    END SUBROUTINE GetInput