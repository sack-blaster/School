PROGRAM CovidCases

! Purpose: This code reads data from a .dat file which shows the number
! of COVID-19 cases reported in the US from 1 March 2020 through 7 April 2020.
! It will then compute the base-10 log of the number of COVID-19 cases, and write
! the logarithmic values of the COVID-19 cases as a function of time to an output 
! data file.
!
! History:
!       Version        Programmer      Date     Description/Comments
!       ------          -------         --      -------------------
!          1          Jacob Archer  02/26/2024  Code created from scratch
!
! SPECIAL REQUESTS: NONE

IMPLICIT NONE

INTEGER :: i, numLines
REAL :: time, COVID19_cases

OPEN(unit=100, file='COVID19Cases/COVID19.dat', status='old', iostat=i)
OPEN(unit=200, file='CovidCasesLOG.dat', status='unknown')

! Check for errors when opening this file
if (i /= 0) then
  write(*,*) 'Error opening COVID10.dat'
  stop
end if

! Read data until end of file is reached
Read_Data: do
    read (100, *, iostat=i) time, COVID19_cases
    if(i/=0) exit ! Exit loop when end of file is reached
    numLines = numLines + 1
    write(200, *) time, LOG10(COVID19_cases)
end do Read_Data

END PROGRAM CovidCases