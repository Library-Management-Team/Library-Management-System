package SystemCode;

import java.util.LinkedList;
import java.util.Queue;

public class ReservationQueue {
    private Queue<Reservation> reservations;

    public ReservationQueue() {
       reservations = new LinkedList<>();
    }

    public void addReservation(LibraryItem libraryItem, Member member) {
        Reservation reservation = new Reservation(libraryItem, member);
        reservations.add(reservation);
    }

    public Reservation getNextReservation(LibraryItem libraryItem) {

        for (Reservation reservation : reservations) {
            if (reservation.getLibraryItem() == libraryItem) {
                return reservation;
            }
        }

        return null;
    }

    public void removeReservation(Reservation reservation) {
        reservations.remove(reservation);
    }

    public int getQueuePosition(LibraryItem libraryItem, Member member) {
    int position = 1;

        for (Reservation reservation : reservations) {
            if (reservation.getLibraryItem() == libraryItem) {

                if (reservation.getMember() == member) {
                    return position;
                }

                position++;
            }
        }

        return -1;
    }
}
