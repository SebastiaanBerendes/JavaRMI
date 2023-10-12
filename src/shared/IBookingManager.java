package shared;

import hotel.BookingDetail;

import java.rmi.Remote;
import java.rmi.RemoteException;

import java.util.Set;
import java.time.LocalDate;

public interface IBookingManager extends Remote {

    public Set<Integer> getAllRooms() throws RemoteException;

    public boolean isRoomAvailable(Integer roomNumber, LocalDate date) throws RemoteException;

    public void addBooking(BookingDetail bookingDetail) throws RemoteException;

    public Set<Integer> getAvailableRooms(LocalDate date) throws RemoteException;
}
