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

        DataCar P_I10 = new DataCar();
        P_I10.SetName("P_I10");
        pn.PlaceList.add(P_I10);

        DataCarQueue P_I11 = new DataCarQueue();
        P_I11.Value.Size = 3;
        P_I11.SetName("P_I11");
        pn.PlaceList.add(P_I11);

        DataString P_TL6 = new DataString();
        P_TL6.SetName("P_TL6");
        pn.PlaceList.add(P_TL6);

        DataCar P_I12 = new DataCar();
        P_I12.SetName("P_I12");
        pn.PlaceList.add(P_I12);

        // -------------------------------------------------------------------
        // -------------------------------Lane2--------------------------------
        // --------------------------------------------------------------------

        DataCar P_I13 = new DataCar();
        P_I13.SetName("P_I13");
        pn.PlaceList.add(P_I13);

        DataCarQueue P_I14 = new DataCarQueue();
        P_I14.Value.Size = 3;
        P_I14.SetName("P_I14");
        pn.PlaceList.add(P_I14);

        DataString P_TL7 = new DataString();
        P_TL7.SetName("P_TL7");
        pn.PlaceList.add(P_TL7);

        DataCar P_I15 = new DataCar();
        P_I15.SetName("P_I15");
        pn.PlaceList.add(P_I15);

        // -------------------------------------------------------------------
        // -------------------------------Lane3--------------------------------
        // --------------------------------------------------------------------

        DataCar P_I7 = new DataCar();
        P_I7.SetName("P_I7");
        pn.PlaceList.add(P_I7);

        DataCarQueue P_I8 = new DataCarQueue();
        P_I8.Value.Size = 3;
        P_I8.SetName("P_I8");
        pn.PlaceList.add(P_I8);

        DataString P_TL5 = new DataString();
        P_TL5.SetName("P_TL5");
        pn.PlaceList.add(P_TL5);

        DataCar P_I9 = new DataCar();
        P_I9.SetName("P_I9");
        pn.PlaceList.add(P_I9);

        // ----------------------------------------------------------------------------
        // ----------------------------Exit lane 1-------------------------------------
        // ----------------------------------------------------------------------------

        DataCarQueue P_O7 = new DataCarQueue(); //p17.Printable = false;
        P_O7.Value.Size = 3;
        P_O7.SetName("P_O7");
        pn.PlaceList.add(P_O7);

        // ----------------------------------------------------------------------------
        // ----------------------------Exit lane 2-------------------------------------
        // ----------------------------------------------------------------------------

        DataCarQueue P_O9 = new DataCarQueue(); //p17.Printable = false;
        P_O9.Value.Size = 3;
        P_O9.SetName("P_O9");
        pn.PlaceList.add(P_O9);

        // -------------------------------------------------------------------------------------------
        // --------------------------------Intersection-----------------------------------------------
        // -------------------------------------------------------------------------------------------

        DataCarQueue P_INT2 = new DataCarQueue();
        P_INT2.Value.Size = 3;
        P_INT2.SetName("P_INT2");
        pn.PlaceList.add(P_INT2);

        // T1 ------------------------------------------------
        PetriTransition T_I10 = new PetriTransition(pn);
        T_I10.TransitionName = "T_I10";
        T_I10.InputPlaceName.add("P_I10");
        T_I10.InputPlaceName.add("P_I11");

        Condition T_I10_Ct1 = new Condition(T_I10, "P_I10", TransitionCondition.NotNull);
        Condition T_I10_Ct2 = new Condition(T_I10, "P_I11", TransitionCondition.CanAddCars);
        T_I10_Ct1.SetNextCondition(LogicConnector.AND, T_I10_Ct2);

        Condition Tu1Ct1 = new Condition(T_I10, "P_I10", TransitionCondition.NotNull);
        Condition Tu1Ct12 = new Condition(T_I10, "P_I11", TransitionCondition.CanNotAddCars);
        Tu1Ct1.SetNextCondition(LogicConnector.AND, Tu1Ct12);

        GuardMapping grdT1 = new GuardMapping();
        grdT1.condition = T_I10_Ct1;
        grdT1.Activations.add(new Activation(T_I10, "P_I10", TransitionOperation.AddElement, "P_I11"));
        T_I10.GuardMappingList.add(grdT1);

        GuardMapping grdTu1 = new GuardMapping();
        grdTu1.condition = Tu1Ct1;
        grdTu1.Activations.add(new Activation(T_I10, "P_I11", TransitionOperation.Copy, "P_I11"));
        T_I10.GuardMappingList.add(grdTu1);

        T_I10.Delay = 0;
        pn.Transitions.add(T_I10);

        // T_I11 ------------------------------------------------
        PetriTransition T_I11 = new PetriTransition(pn);
        T_I11.TransitionName = "T_I11";
        T_I11.InputPlaceName.add("P_I11");
        T_I11.InputPlaceName.add("P_TL6");

        Condition T_I11Ct1 = new Condition(T_I11, "P_TL6", TransitionCondition.Equal, "green");
        Condition T_I11Ct2 = new Condition(T_I11, "P_I11", TransitionCondition.HaveCar);
        T_I11Ct1.SetNextCondition(LogicConnector.AND, T_I11Ct2);

        GuardMapping grdT_I11 = new GuardMapping();
        grdT_I11.condition = T_I11Ct1;
        grdT_I11.Activations.add(new Activation(T_I11, "P_I11", TransitionOperation.PopElementWithoutTarget, "P_I12"));
        grdT_I11.Activations.add(new Activation(T_I11, "P_TL6", TransitionOperation.Move, "P_TL6"));

        T_I11.GuardMappingList.add(grdT_I11);
        T_I11.Delay = 0;
        pn.Transitions.add(T_I11);

        // T3 ------------------------------------------------
        PetriTransition T_I13 = new PetriTransition(pn);
        T_I13.TransitionName = "T_I13";
        T_I13.InputPlaceName.add("P_I13");
        T_I13.InputPlaceName.add("P_I14");

        Condition T3Ct1 = new Condition(T_I13, "P_I13", TransitionCondition.NotNull);
        Condition T3Ct2 = new Condition(T_I13, "P_I14", TransitionCondition.CanAddCars);
        T3Ct1.SetNextCondition(LogicConnector.AND, T3Ct2);

        Condition Tu2Ct1 = new Condition(T_I13, "P_I13", TransitionCondition.NotNull);
        Condition Tu2Ct12 = new Condition(T_I13, "P_I14", TransitionCondition.CanNotAddCars);
        Tu2Ct1.SetNextCondition(LogicConnector.AND, Tu2Ct12);

        GuardMapping grdT3 = new GuardMapping();
        grdT3.condition = T3Ct1;
        grdT3.Activations.add(new Activation(T_I13, "P_I13", TransitionOperation.AddElement, "P_I14"));
        T_I13.GuardMappingList.add(grdT3);

        GuardMapping grdTu3 = new GuardMapping();
        grdTu3.condition = Tu2Ct1;
        grdTu3.Activations.add(new Activation(T_I13, "P_I14", TransitionOperation.Copy, "P_I14"));
        T_I13.GuardMappingList.add(grdTu3);

        T_I13.Delay = 0;
        pn.Transitions.add(T_I13);

        // T4 ------------------------------------------------
        PetriTransition T_I15 = new PetriTransition(pn);
        T_I15.TransitionName = "T_I15";
        T_I15.InputPlaceName.add("P_I14");
        T_I15.InputPlaceName.add("P_TL7");

        Condition T4Ct1 = new Condition(T_I15, "P_TL7", TransitionCondition.Equal, "green");
        Condition T4Ct2 = new Condition(T_I15, "P_I14", TransitionCondition.HaveCar);
        T4Ct1.SetNextCondition(LogicConnector.AND, T4Ct2);

        GuardMapping grdT4 = new GuardMapping();
        grdT4.condition = T4Ct1;
        grdT4.Activations.add(new Activation(T_I15, "P_I14", TransitionOperation.PopElementWithoutTarget, "P_I15"));
        grdT4.Activations.add(new Activation(T_I15, "P_TL7", TransitionOperation.Move, "P_TL7"));

        T_I15.GuardMappingList.add(grdT4);
        T_I15.Delay = 0;
        pn.Transitions.add(T_I15);

        // T5 ------------------------------------------------
        PetriTransition T_I7 = new PetriTransition(pn);
        T_I7.TransitionName = "T_I7";
        T_I7.InputPlaceName.add("P_I7");
        T_I7.InputPlaceName.add("P_I8");

        Condition T_I7Ct1 = new Condition(T_I7, "P_I7", TransitionCondition.NotNull);
        Condition T_I7Ct2 = new Condition(T_I7, "P_I8", TransitionCondition.CanAddCars);
        T_I7Ct1.SetNextCondition(LogicConnector.AND, T_I7Ct2);

        Condition T_I7_Ct1 = new Condition(T_I7, "P_I7", TransitionCondition.NotNull);
        Condition T_I7_Ct12 = new Condition(T_I7, "P_I8", TransitionCondition.CanNotAddCars);
        T_I7_Ct1.SetNextCondition(LogicConnector.AND, T_I7_Ct12);

        GuardMapping grdT_I7 = new GuardMapping();
        grdT_I7.condition = T_I7Ct1;
        grdT_I7.Activations.add(new Activation(T_I7, "P_I7", TransitionOperation.AddElement, "P_I8"));
        T_I7.GuardMappingList.add(grdT_I7);

        GuardMapping grdTu5 = new GuardMapping();
        grdTu5.condition = T_I7_Ct1;
        grdTu5.Activations.add(new Activation(T_I7, "P_I8", TransitionOperation.Copy, "P_I8"));
        T_I7.GuardMappingList.add(grdTu5);

        T_I7.Delay = 0;
        pn.Transitions.add(T_I7);

        // T6 ------------------------------------------------
        PetriTransition T_I8 = new PetriTransition(pn);
        T_I8.TransitionName = "T_I8";
        T_I8.InputPlaceName.add("P_I8");
        T_I8.InputPlaceName.add("P_TL5");

        Condition T_I8Ct1 = new Condition(T_I8, "P_TL5", TransitionCondition.Equal, "green");
        Condition T_I8Ct2 = new Condition(T_I8, "P_I8", TransitionCondition.HaveCar);
        T_I8Ct1.SetNextCondition(LogicConnector.AND, T_I8Ct2);

        GuardMapping grdT_I8 = new GuardMapping();
        grdT_I8.condition = T_I8Ct1;
        grdT_I8.Activations.add(new Activation(T_I8, "P_I8", TransitionOperation.PopElementWithoutTarget, "P_I9"));
        grdT_I8.Activations.add(new Activation(T_I8, "P_TL5", TransitionOperation.Move, "P_TL5"));

        T_I8.GuardMappingList.add(grdT_I8);
        T_I8.Delay = 0;
        pn.Transitions.add(T_I8);

        // --------------------------------------firstpart-------------------------------------------

        // T_I12 ------------------------------------------------
        PetriTransition T_I12 = new PetriTransition(pn);
        T_I12.TransitionName = "T_I12";
        T_I12.InputPlaceName.add("P_I3");
        T_I12.InputPlaceName.add("P_INT2");

        Condition TI3_inCt1 = new Condition(T_I12, "P_I3", TransitionCondition.NotNull);
        Condition TI3_inCt2 = new Condition(T_I12, "P_INT2", TransitionCondition.CanAddCars);
        TI3_inCt1.SetNextCondition(LogicConnector.AND, TI3_inCt2);

        GuardMapping grdTI3_in = new GuardMapping();
        grdTI3_in.condition = TI3_inCt1;
        grdTI3_in.Activations.add(new Activation(T_I12, "P_I3", TransitionOperation.AddElement, "P_INT2"));
        T_I12.GuardMappingList.add(grdTI3_in);

        T_I12.Delay = 0;
        pn.Transitions.add(T_I12);

        // T_O7-----------------------------------------------------------
        PetriTransition T_O7 = new PetriTransition(pn);
        T_O7.TransitionName = "T_O7";
        T_O7.InputPlaceName.add("P_INT2");
        T_O7.InputPlaceName.add("P_O7");

        Condition T_O1_Ct1 = new Condition(T_O7, "P_INT2", TransitionCondition.HaveCarForMe);
        Condition T_O1_Ct2 = new Condition(T_O7, "P_O7", TransitionCondition.CanAddCars);
        T_O1_Ct1.SetNextCondition(LogicConnector.AND, T_O1_Ct2);

        GuardMapping grdT_O1 = new GuardMapping();
        grdT_O1.condition = T_O1_Ct1;
        grdT_O1.Activations.add(new Activation(T_O7, "P_INT2", TransitionOperation.PopElementWithTargetToQueue, "P_O7"));
        T_O7.GuardMappingList.add(grdT_O1);

        T_O7.Delay = 0;
        pn.Transitions.add(T_O7);

        // --------------------------------------secondpart-------------------------------------------

        // T_I16 ------------------------------------------------
        PetriTransition T_I16 = new PetriTransition(pn);
        T_I16.TransitionName = "T_I16";
        T_I16.InputPlaceName.add("P_I6");
        T_I16.InputPlaceName.add("P_INT2");

        Condition T_I6_Ct1 = new Condition(T_I16, "P_I16", TransitionCondition.NotNull);
        Condition T_I6_Ct2 = new Condition(T_I16, "P_INT2", TransitionCondition.CanAddCars);
        T_I6_Ct1.SetNextCondition(LogicConnector.AND, T_I6_Ct2);

        GuardMapping grdT_I6 = new GuardMapping();
        grdT_I6.condition = T_I6_Ct1;
        grdT_I6.Activations.add(new Activation(T_I16, "P_I16", TransitionOperation.AddElement, "P_INT2"));
        T_I16.GuardMappingList.add(grdT_I6);

        T_I16.Delay = 0;
        pn.Transitions.add(T_I16);

        // T_O9-----------------------------------------------------------
        PetriTransition T_O9 = new PetriTransition(pn);
        T_O9.TransitionName = "T_O9";
        T_O9.InputPlaceName.add("P_INT2");
        T_O9.InputPlaceName.add("P_O9");

        Condition T_O3_Ct1 = new Condition(T_O9, "P_INT2", TransitionCondition.HaveCarForMe);
        Condition T_O3_Ct2 = new Condition(T_O9, "P_O9", TransitionCondition.CanAddCars);
        T_O3_Ct1.SetNextCondition(LogicConnector.AND, T_O3_Ct2);

        GuardMapping grdT_O3 = new GuardMapping();
        grdT_O3.condition = T_O3_Ct1;
        grdT_O3.Activations.add(new Activation(T_O9, "P_INT2", TransitionOperation.PopElementWithTargetToQueue, "P_O9"));
        T_O9.GuardMappingList.add(grdT_O3);

        T_O9.Delay = 0;
        pn.Transitions.add(T_O9);

        // --------------------------------------thirdpart-------------------------------------------

        // T_M3 ------------------------------------------------
        PetriTransition T_M3 = new PetriTransition(pn);
        T_M3.TransitionName = "T_M3";
        T_M3.InputPlaceName.add("P_M2");
        T_M3.InputPlaceName.add("P_INT2");

        Condition T_M3_Ct1 = new Condition(T_M3, "P_M2", TransitionCondition.NotNull);
        Condition T_M3_Ct2 = new Condition(T_M3, "P_INT2", TransitionCondition.CanAddCars);
        T_M3_Ct1.SetNextCondition(LogicConnector.AND, T_M3_Ct2);

        GuardMapping grdT_M3 = new GuardMapping();
        grdT_M3.condition = T_M3_Ct1;
        grdT_M3.Activations.add(new Activation(T_M3, "P_M2", TransitionOperation.AddElement, "P_INT2"));
        T_M3.GuardMappingList.add(grdT_M3);

        T_M3.Delay = 0;
        pn.Transitions.add(T_M3);

        // T_O5-----------------------------------------------------------
//        PetriTransition T_O5 = new PetriTransition(pn);
//        T_O5.TransitionName = "T_O5";
//        T_O5.InputPlaceName.add("P_INT2");
//        T_O5.InputPlaceName.add("P_O5");
//
//        Condition T_O5_Ct1 = new Condition(T_O5, "P_INT2", TransitionCondition.HaveCarForMe);
//        Condition T_O5_Ct2 = new Condition(T_O5, "P_O5", TransitionCondition.CanAddCars);
//        T_O5_Ct1.SetNextCondition(LogicConnector.AND, T_O5_Ct2);
//
//        GuardMapping grdT_O5 = new GuardMapping();
//        grdT_O5.condition = T_O5_Ct1;
//        grdT_O5.Activations.add(new Activation(T_O5, "P_INT2", TransitionOperation.PopElementWithTargetToQueue, "P_O5"));
//        T_O5.GuardMappingList.add(grdT_O5);
//
//        T_O5.Delay = 0;
//        pn.Transitions.add(T_O5);

        // --------------------------------------fourthpart-------------------------------------------

        // T_M4 ------------------------------------------------
        PetriTransition T_M4 = new PetriTransition(pn);
        T_M4.TransitionName = "T_M4";
        T_M4.InputPlaceName.add("P_M3");
        T_M4.InputPlaceName.add("P_INT2");

        Condition T_M6_Ct1 = new Condition(T_M4, "P_M3", TransitionCondition.NotNull);
        Condition T_M6_Ct2 = new Condition(T_M4, "P_INT2", TransitionCondition.CanAddCars);
        T_M6_Ct1.SetNextCondition(LogicConnector.AND, T_M6_Ct2);

        GuardMapping grdT_M6 = new GuardMapping();
        grdT_M6.condition = T_M6_Ct1;
        grdT_M6.Activations.add(new Activation(T_M4, "P_M3", TransitionOperation.AddElement, "P_INT2"));
        T_M3.GuardMappingList.add(grdT_M3);

        T_M3.Delay = 0;
        pn.Transitions.add(T_M3);

        // T_O5-----------------------------------------------------------
//        PetriTransition T_O5 = new PetriTransition(pn);
//        T_O5.TransitionName = "T_O5";
//        T_O5.InputPlaceName.add("P_INT2");
//        T_O5.InputPlaceName.add("P_O5");
//
//        Condition T_O5_Ct3 = new Condition(T_O5, "P_INT2", TransitionCondition.HaveCarForMe);
//        Condition T_O5_Ct4 = new Condition(T_O5, "P_O5", TransitionCondition.CanAddCars);
//        T_O5_Ct3.SetNextCondition(LogicConnector.AND, T_O5_Ct4);
//
//        GuardMapping grdT_O5_1 = new GuardMapping();
//        grdT_O5_1.condition = T_O5_Ct3;
//        grdT_O5_1.Activations.add(new Activation(T_O5, "P_INT2", TransitionOperation.PopElementWithTargetToQueue, "P_O5"));
//        T_O5.GuardMappingList.add(grdT_O5);
//
//        T_O5.Delay = 0;
//        pn.Transitions.add(T_O5);


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
