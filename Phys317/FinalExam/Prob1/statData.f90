Program StatDataAnalysis
    IMPLICIT NONE

    ! Initialize variables
    REAL, allocatable :: data(:)
    REAL :: mean, variance, std_dev, dummy
    INTEGER :: i, n, m, dim, AllocStat, DeallocStat, IOStat

    ! Open the file, use iostat to check for errors
    OPEN(10, file='LeadConcentrations.dat', status='old', iostat=IOStat)
    IF (IOStat /= 0) STOP 'Error opening file'

    ! Determine how much space to allocate for the data
    DO; READ(10,*,end=50) dummy; m=m+1
    END DO
    50 CONTINUE
    dim = m ! Arrays need to have this dimension
    REWIND(10)
    
    ! Allocate space for the data
    ALLOCATE(data(dim), STAT=AllocStat)
    if (AllocStat /=0) STOP 'Not enough memory'

    n = dim
    ! Read the data
    makeArray: DO i=1,n
                READ(10,*) data(i)
            END DO makeArray

    ! If number of data points is less than 2, stop the program
    IF (n < 2) STOP 'Not enough data points'

    ! Calculate the mean, variance, and standard deviation
    mean = SUM(data)/n

    variance = 0
    DO i=1,n
        variance = variance + (data(i) - mean)**2
    END DO

    variance = variance/(n-1)

    std_dev = SQRT(variance)

    ! Output the results
    WRITE(*,*) 'The mean of this data set is ', mean
    WRITE(*,*) 'The variance of this data set is ', variance
    WRITE(*,*) 'The standard deviation of this data set is ', std_dev
    WRITE(*,*) 'The number of data points is ', n

    ! Deallocate the array
    DEALLOCATE(data, STAT=DeallocStat)
    IF (DeallocStat /= 0) STOP 'Error deallocating memory'

    ! Close the file
    CLOSE(10)

END Program StatDataAnalysis