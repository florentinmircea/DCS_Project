package NullPointerException;

import Components.*;
import DataObjects.DataCar;
import DataObjects.DataCarQueue;
import DataObjects.DataString;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class Second_Intersection {
    public static void main(String[] args) {
        PetriNet pn = new PetriNet();
        pn.PetriNetName = "Second Intersection";

        pn.NetworkPort = 1081;

        // -------------------------------------------------------------------
        // -------------------------------Lane1--------------------------------
        // --------------------------------------------------------------------

        DataCar p28 = new DataCar();
        p28.SetName("P28");
        pn.PlaceList.add(p28);

        DataCarQueue p29 = new DataCarQueue();
        p29.Value.Size = 3;
        p29.SetName("P29");
        pn.PlaceList.add(p29);

        DataString p31 = new DataString();
        p31.SetName("P31");
        pn.PlaceList.add(p31);

        DataCar p30 = new DataCar();
        p30.SetName("P30");
        pn.PlaceList.add(p30);

        // -------------------------------------------------------------------
        // -------------------------------Lane2--------------------------------
        // --------------------------------------------------------------------

        DataCar p36 = new DataCar();
        p36.SetName("P36");
        pn.PlaceList.add(p36);

        DataCarQueue p37 = new DataCarQueue();
        p37.Value.Size = 3;
        p37.SetName("P37");
        pn.PlaceList.add(p37);

        DataString p39 = new DataString();
        p39.SetName("P39");
        pn.PlaceList.add(p39);

        DataCar p38 = new DataCar();
        p38.SetName("P38");
        pn.PlaceList.add(p38);

        // -------------------------------------------------------------------
        // -------------------------------Lane3--------------------------------
        // --------------------------------------------------------------------

        DataCar p40 = new DataCar();
        p40.SetName("P40");
        pn.PlaceList.add(p40);

        DataCarQueue p41 = new DataCarQueue();
        p41.Value.Size = 3;
        p41.SetName("P41");
        pn.PlaceList.add(p41);

        DataString p43 = new DataString();
        p43.SetName("P43");
        pn.PlaceList.add(p43);

        DataCar p42 = new DataCar();
        p42.SetName("P42");
        pn.PlaceList.add(p42);

        // ----------------------------------------------------------------------------
        // ----------------------------Exit lane 1-------------------------------------
        // ----------------------------------------------------------------------------

        DataCarQueue p25 = new DataCarQueue(); //p17.Printable = false;
        p25.Value.Size = 3;
        p25.SetName("P_o1");
        pn.PlaceList.add(p25);

        // ----------------------------------------------------------------------------
        // ----------------------------Exit lane 2-------------------------------------
        // ----------------------------------------------------------------------------

        DataCarQueue p27 = new DataCarQueue(); //p17.Printable = false;
        p27.Value.Size = 3;
        p27.SetName("P_o2");
        pn.PlaceList.add(p27);

        // -------------------------------------------------------------------------------------------
        // --------------------------------Intersection-----------------------------------------------
        // -------------------------------------------------------------------------------------------

        DataCarQueue p24 = new DataCarQueue();
        p24.Value.Size = 3;
        p24.SetName("P_I");
        pn.PlaceList.add(p24);

        // T1 ------------------------------------------------
        PetriTransition t1 = new PetriTransition(pn);
        t1.TransitionName = "T_u1";
        t1.InputPlaceName.add("P28");
        t1.InputPlaceName.add("P29");

        Condition T1Ct1 = new Condition(t1, "P28", TransitionCondition.NotNull);
        Condition T1Ct2 = new Condition(t1, "P29", TransitionCondition.CanAddCars);
        T1Ct1.SetNextCondition(LogicConnector.AND, T1Ct2);

        Condition Tu1Ct1 = new Condition(t1, "P28", TransitionCondition.NotNull);
        Condition Tu1Ct12 = new Condition(t1, "P29", TransitionCondition.CanNotAddCars);
        Tu1Ct1.SetNextCondition(LogicConnector.AND, Tu1Ct12);

        GuardMapping grdT1 = new GuardMapping();
        grdT1.condition = T1Ct1;
        grdT1.Activations.add(new Activation(t1, "P28", TransitionOperation.AddElement, "P29"));
        t1.GuardMappingList.add(grdT1);

        GuardMapping grdTu1 = new GuardMapping();
        grdTu1.condition = Tu1Ct1;
        grdTu1.Activations.add(new Activation(t1, "P29", TransitionOperation.Copy, "P29"));
        t1.GuardMappingList.add(grdTu1);

        t1.Delay = 0;
        pn.Transitions.add(t1);

        // T2 ------------------------------------------------
        PetriTransition t2 = new PetriTransition(pn);
        t2.TransitionName = "T2";
        t2.InputPlaceName.add("P29");
        t2.InputPlaceName.add("P31");

        Condition T2Ct1 = new Condition(t2, "P31", TransitionCondition.Equal, "green");
        Condition T2Ct2 = new Condition(t2, "P29", TransitionCondition.HaveCar);
        T2Ct1.SetNextCondition(LogicConnector.AND, T2Ct2);

        GuardMapping grdT2 = new GuardMapping();
        grdT2.condition = T2Ct1;
        grdT2.Activations.add(new Activation(t2, "P29", TransitionOperation.PopElementWithoutTarget, "P30"));
        grdT2.Activations.add(new Activation(t2, "P31", TransitionOperation.Move, "P31"));

        t2.GuardMappingList.add(grdT2);
        t2.Delay = 0;
        pn.Transitions.add(t2);

        // T3 ------------------------------------------------
        PetriTransition t3 = new PetriTransition(pn);
        t3.TransitionName = "T_u2";
        t3.InputPlaceName.add("P36");
        t3.InputPlaceName.add("P37");

        Condition T3Ct1 = new Condition(t3, "P36", TransitionCondition.NotNull);
        Condition T3Ct2 = new Condition(t3, "P37", TransitionCondition.CanAddCars);
        T3Ct1.SetNextCondition(LogicConnector.AND, T3Ct2);

        Condition Tu2Ct1 = new Condition(t3, "P36", TransitionCondition.NotNull);
        Condition Tu2Ct12 = new Condition(t3, "P37", TransitionCondition.CanNotAddCars);
        Tu2Ct1.SetNextCondition(LogicConnector.AND, Tu2Ct12);

        GuardMapping grdT3 = new GuardMapping();
        grdT3.condition = T3Ct1;
        grdT3.Activations.add(new Activation(t3, "P36", TransitionOperation.AddElement, "P37"));
        t3.GuardMappingList.add(grdT3);

        GuardMapping grdTu3 = new GuardMapping();
        grdTu3.condition = Tu2Ct1;
        grdTu3.Activations.add(new Activation(t3, "P37", TransitionOperation.Copy, "P37"));
        t3.GuardMappingList.add(grdTu3);

        t3.Delay = 0;
        pn.Transitions.add(t3);

        // T4 ------------------------------------------------
        PetriTransition t4 = new PetriTransition(pn);
        t4.TransitionName = "T4";
        t4.InputPlaceName.add("P37");
        t4.InputPlaceName.add("P39");

        Condition T4Ct1 = new Condition(t4, "P39", TransitionCondition.Equal, "green");
        Condition T4Ct2 = new Condition(t4, "P37", TransitionCondition.HaveCar);
        T4Ct1.SetNextCondition(LogicConnector.AND, T4Ct2);

        GuardMapping grdT4 = new GuardMapping();
        grdT4.condition = T4Ct1;
        grdT4.Activations.add(new Activation(t4, "P37", TransitionOperation.PopElementWithoutTarget, "P38"));
        grdT4.Activations.add(new Activation(t4, "P39", TransitionOperation.Move, "P39"));

        t4.GuardMappingList.add(grdT4);
        t4.Delay = 0;
        pn.Transitions.add(t4);

        // T5 ------------------------------------------------
        PetriTransition t5 = new PetriTransition(pn);
        t5.TransitionName = "T_u3";
        t5.InputPlaceName.add("P40");
        t5.InputPlaceName.add("P41");

        Condition T5Ct1 = new Condition(t5, "P40", TransitionCondition.NotNull);
        Condition T5Ct2 = new Condition(t5, "P41", TransitionCondition.CanAddCars);
        T5Ct1.SetNextCondition(LogicConnector.AND, T5Ct2);

        Condition Tu5Ct1 = new Condition(t5, "P40", TransitionCondition.NotNull);
        Condition Tu5Ct12 = new Condition(t5, "P41", TransitionCondition.CanNotAddCars);
        Tu5Ct1.SetNextCondition(LogicConnector.AND, Tu5Ct12);

        GuardMapping grdT5 = new GuardMapping();
        grdT5.condition = T5Ct1;
        grdT5.Activations.add(new Activation(t5, "P40", TransitionOperation.AddElement, "P41"));
        t5.GuardMappingList.add(grdT5);

        GuardMapping grdTu5 = new GuardMapping();
        grdTu5.condition = Tu5Ct1;
        grdTu5.Activations.add(new Activation(t5, "P41", TransitionOperation.Copy, "P41"));
        t5.GuardMappingList.add(grdTu5);

        t5.Delay = 0;
        pn.Transitions.add(t5);

        // T6 ------------------------------------------------
        PetriTransition t6 = new PetriTransition(pn);
        t6.TransitionName = "T6";
        t6.InputPlaceName.add("P41");
        t6.InputPlaceName.add("P43");

        Condition T6Ct1 = new Condition(t6, "P43", TransitionCondition.Equal, "green");
        Condition T6Ct2 = new Condition(t6, "P41", TransitionCondition.HaveCar);
        T6Ct1.SetNextCondition(LogicConnector.AND, T6Ct2);

        GuardMapping grdT6 = new GuardMapping();
        grdT6.condition = T6Ct1;
        grdT6.Activations.add(new Activation(t6, "P41", TransitionOperation.PopElementWithoutTarget, "P42"));
        grdT6.Activations.add(new Activation(t6, "P43", TransitionOperation.Move, "P43"));

        t6.GuardMappingList.add(grdT6);
        t6.Delay = 0;
        pn.Transitions.add(t6);

        // -------------------------------------------------------------------------------------
        // ----------------------------PNStart-------------------------------------------------
        // -------------------------------------------------------------------------------------

        System.out.println("Second Intersection started \n ------------------------------");
        pn.Delay = 2000;
        // pn.Start();

        PetriNetWindow frame = new PetriNetWindow(false);
        frame.petriNet = pn;
        frame.setVisible(true);
    }
}
