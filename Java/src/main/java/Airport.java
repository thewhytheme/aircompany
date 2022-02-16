import Planes.ExperimentalPlane;
import models.MilitaryType;
import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Airport {

    private List<? extends Plane> planes;

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

    public List<PassengerPlane> getPassengersPlanesList() {
        List<PassengerPlane> listOfPassengersPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof PassengerPlane) {
                listOfPassengersPlanes.add((PassengerPlane) plane);
            }
        }
        return listOfPassengersPlanes;
    }

    public List<MilitaryPlane> getMilitaryPlanesList() {
        List<MilitaryPlane> militaryPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof MilitaryPlane) {
                militaryPlanes.add((MilitaryPlane) plane);
            }
        }
        return militaryPlanes;
    }

       public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
            List<PassengerPlane> passengerPlanes = getPassengersPlanesList();
            PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
            for (PassengerPlane passengerPlane : passengerPlanes) {
                if (passengerPlane.getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                    planeWithMaxCapacity = passengerPlane;
                }
            }
            return planeWithMaxCapacity;
        }

        public List<MilitaryPlane> getTransportMilitaryPlanes() {
            List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();
            List<MilitaryPlane> militaryPlanesList = getMilitaryPlanesList();
            for (MilitaryPlane plane : militaryPlanesList) {
                if (plane.getType().equals(MilitaryType.TRANSPORT)) {
                    transportMilitaryPlanes.add(plane);
                }
            }
            return transportMilitaryPlanes;
        }

        public List<MilitaryPlane> getBomberMilitaryPlanes () {
            List<MilitaryPlane> bomberMilitaryPlanes = new ArrayList<>();
            List<MilitaryPlane> militaryPlanesBomber = getMilitaryPlanesList();
            for (MilitaryPlane plane: militaryPlanesBomber) {
                if (plane.getType().equals(MilitaryType.BOMBER)) {
                    bomberMilitaryPlanes.add(plane);
                }
            }
            return bomberMilitaryPlanes;
        }

        public List <ExperimentalPlane> getExperimentalPlanesList () {
            List<ExperimentalPlane> experimentalPlanesList = new ArrayList<>();
            for (Plane plane : planes) {
                if (plane instanceof ExperimentalPlane) {
                    experimentalPlanesList.add((ExperimentalPlane) plane);
                }
            }
            return experimentalPlanesList;
        }

        public Airport sortByMaxDistance () {
            planes.sort(new Comparator<Plane>() {
                public int compare(Plane o1, Plane o2) {
                    return o1.getMaxFlightDistance() - o2.getMaxFlightDistance();
                }
            });
            return new Airport(planes);
        }

        public Airport sortByMaxSpeed () {
            planes.sort(new Comparator<Plane>() {
                public int compare(Plane o1, Plane o2) {
                    return o1.getMaxSpeed() - o2.getMaxSpeed();
                }
            });
            return new Airport(planes);
        }

        public Airport sortByMaxLoadCapacity () {
            planes.sort(new Comparator<Plane>() {
                public int compare(Plane o1, Plane o2) {
                    return o1.getMaxLoadCapacity() - o2.getMaxLoadCapacity();
                }
            });
            return new Airport(planes);
        }

        public List<? extends Plane> getPlanes () {
            return planes;
        }

        private void print (Collection< ? extends Plane > collection){
            for (Plane plane : collection) {
                System.out.println(plane);
            }
        }

        @Override
        public String toString () {
            return "Airport{" +
                    "Planes=" + planes.toString() +
                    '}';
        }


    }

