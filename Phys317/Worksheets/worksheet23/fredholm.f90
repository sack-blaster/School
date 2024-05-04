program FredholmIntegralEquation

      implicit none
      real :: x, y, fx, kxy, tolerance, dx, dy
      real :: sum, difference
      real, allocatable ::  psi_old(:), psi_new(:)             
      integer :: nx, ny, ix, iy, iterations, iterationLimit, AllocateStatus, DeAllocateStatus

      data tolerance/1.0E-04/, nx/20/, iterationLimit/20/
      
      ! Allocate memory for arrays x and y
allocate(psi_old(iterationLimit), stat=AllocateStatus)
if (AllocateStatus /=0) STOP 'Not enough memory'
allocate(psi_new(iterationLimit), stat=AllocateStatus)
if (AllocateStatus /=0) STOP 'Not enough memory'
      
      open(unit=500, file='integralEquation.dat', status='unknown')
      
      ny = nx

      dx = 1.0 / real(nx);  dy = 1.0 / real(ny)

      do ix = 0, nx  ! Initialize  Psi(i) (= fx(x), x from [0,1])
         x = dx*real(ix)
         psi_old(ix) = fx(x)
      end do
      
Interations:  do iterations = 1, iterationLimit  

x_interval:   do ix = 0, nx        ! x from [0, 1]
                 x = dx * real(ix)
           
                    sum = 0.0            
Integrate_over_y: do iy = 1, ny-1   
                     y = dy * real(iy)
                     sum = sum + kxy(x,y) * psi_old(iy) 
                  end do Integrate_over_y
       psi_new(ix) = fx(x) + dy * (  kxy(x,0.)*psi_old(1) &
                                + kxy(x,1.)*psi_old(ny) + 2.*sum ) /2.0 
       end do x_interval
       
        
        difference = 0.
        do ix = 0, nx
           difference = difference + abs(abs(psi_old(ix)) -&
                & abs(psi_new(ix))) / abs(psi_new(ix))
        end do
        
        write(* , 90) iterations, difference
     90 format(' Iteration number: ', I2,',', 3x, 'Diff =', E13.6)
        if (difference <= tolerance) then
           EXIT
        else
           if (iterations == iterationLimit) write(*,"(// 'Discard solution!!' //)")
        end if
        
        
        do ix = 0, nx
           psi_old(ix) = psi_new(ix)
        end do
        
     end do Interations
     
      
200  continue
      
        write(*, *) 'Number of iterations=', iterations

         do ix = 0, nx
             x = dx * real(ix)
             write(*, 100) x, psi_old(ix), psi_new(ix)
             write(500,*) x, psi_new(ix)
  100        format(1x, 'x=', F4.2,',   psi(old) =', E13.6,',   psi(new) =', E13.6)
          end do
          
        stop '--> Regular program stop encountered'
end program FredholmIntegralEquation


FUNCTION fx(x)
IMPLICIT NONE
REAL, INTENT(IN) :: x
REAL :: fx

fx = (x**2*sin(x) - x*cos(x) + 2.0*sin(x)) * exp(-x) / (1.0 + x**2)

END FUNCTION fx

FUNCTION kxy(x, y)
IMPLICIT NONE
REAL, INTENT(IN) :: x, y
REAL :: kxy

kxy = y / (1. + x**2)

END FUNCTION kxy
