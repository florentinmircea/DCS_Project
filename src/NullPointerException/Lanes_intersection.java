package NullPointerException;

import Components.*;
import DataObjects.DataCar;
import DataObjects.DataCarQueue;
import DataObjects.DataString;
import DataObjects.DataTransfer;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class Lanes_intersection {
    public static void main(String[] args) {
        PetriNet pn = new PetriNet();
        pn.PetriNetName = "Lanes Intersection";

        pn.NetworkPort = 1080;

        DataString green = new DataString();
        green.Printable = false;
        green.SetName("green");
        green.SetValue("green");
        pn.ConstantPlaceList.add(green);

        DataString full = new DataString();
        full.Printable = false;
        full.SetName("full");
        full.SetValue("full");
        pn.ConstantPlaceList.add(full);

        // -------------------------------------------------------------------
        // -------------------------------Int1--------------------------------
        // --------------------------------------------------------------------


        // -------------------------------------------------------------------
        // -------------------------------Lane1--------------------------------
        // --------------------------------------------------------------------

        DataCar P_I1 = new DataCar();
        P_I1.SetName("P_I1");
        pn.PlaceList.add(P_I1);

        DataCarQueue P_I2 = new DataCarQueue();
        P_I2.Value.Size = 3;
        P_I2.SetName("P_I2");
        pn.PlaceList.add(P_I2);

        DataString P_TL1 = new DataString();
        P_TL1.SetName("P_TL1");
        pn.PlaceList.add(P_TL1);

        DataCar P_I3 = new DataCar();
        P_I3.SetName("P_I3");
        pn.PlaceList.add(P_I3);

        DataTransfer OP1 = new DataTransfer();
        OP1.Value=new TransferOperation("localhost","1081","in1");
        OP1.SetName("OP1");
        pn.PlaceList.add(OP1);

        // -------------------------------------------------------------------
        // -------------------------------Lane2--------------------------------
        // --------------------------------------------------------------------

        DataCar P_I4 = new DataCar();
        P_I4.SetName("P_I4");
        pn.PlaceList.add(P_I4);

        DataCarQueue P_I5 = new DataCarQueue();
        P_I5.Value.Size = 3;
        P_I5.SetName("P_I5");
        pn.PlaceList.add(P_I5);

        DataString P_TL2 = new DataString();
        P_TL2.SetName("P_TL2");
        pn.PlaceList.add(P_TL2);

        DataCar P_I6 = new DataCar();
        P_I6.SetName("P_I6");
        pn.PlaceList.add(P_I6);

        DataTransfer OP2 = new DataTransfer();
        OP2.SetName("OP2");
        OP2.Value=new TransferOperation("localhost","1081","in2");
        pn.PlaceList.add(OP2);

        // -------------------------------------------------------------------
        // -------------------------------Lane3--------------------------------
        // --------------------------------------------------------------------

        DataCarQueue P_M3 = new DataCarQueue();
        P_M3.Value.Size = 3;
        P_M3.SetName("P_M3");
        pn.PlaceList.add(P_M3);

        DataString P_TL4 = new DataString();
        P_TL4.SetName("P_TL4");
        pn.PlaceList.add(P_TL4);

        DataCar P_M4 = new DataCar();
        P_M4.SetName("P_M4");
        pn.PlaceList.add(P_M4);

        // ----------------------------------------------------------------------------
        // ----------------------------Exit lane 1-------------------------------------
        // ----------------------------------------------------------------------------

        DataCarQueue P_O1 = new DataCarQueue();
        P_O1.Value.Size = 3;
        P_O1.SetName("P_O1");
        pn.PlaceList.add(P_O1);

        DataCar P_O2 = new DataCar();
        P_O2.SetName("P_O2");
        pn.PlaceList.add(P_O2);

        // ----------------------------------------------------------------------------
        // ----------------------------Exit lane 2-------------------------------------
        // ----------------------------------------------------------------------------

        DataCarQueue P_O5 = new DataCarQueue();
        P_O5.Value.Size = 3;
        P_O5.SetName("P_O5");
        pn.PlaceList.add(P_O5);

        DataCar P_O6 = new DataCar();
        P_O6.SetName("P_O6");
        pn.PlaceList.add(P_O6);

        // ----------------------------------------------------------------------------
        // ----------------------------Exit lane 3-------------------------------------
        // ----------------------------------------------------------------------------

        DataCarQueue P_O3 = new DataCarQueue();
        P_O3.Value.Size = 3;
        P_O3.SetName("P_O3");
        pn.PlaceList.add(P_O3);

        DataCar P_O4 = new DataCar();
        P_O4.SetName("P_O4");
        pn.PlaceList.add(P_O4);

        // -------------------------------------------------------------------
        // -------------------------------Int2--------------------------------
        // --------------------------------------------------------------------

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

        DataTransfer OP4 = new DataTransfer();
        OP4.Value=new TransferOperation("localhost","1082","in4");
        OP4.SetName("OP4");
        pn.PlaceList.add(OP4);

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

        DataTransfer OP5 = new DataTransfer();
        OP5.Value=new TransferOperation("localhost","1082","in5");
        OP5.SetName("OP5");
        pn.PlaceList.add(OP5);

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

        DataTransfer OP3 = new DataTransfer();
        OP3.Value=new TransferOperation("localhost","1082","in3");
        OP3.SetName("OP3");
        pn.PlaceList.add(OP3);

        // -------------------------------------------------------------------
        // -------------------------------Lane4--------------------------------
        // --------------------------------------------------------------------

        DataCarQueue P_M1 = new DataCarQueue();
        P_M1.SetName("P_M1");
        pn.PlaceList.add(P_M1);

        DataString P_TL3 = new DataString();
        P_TL3.SetName("P_TL3");
        pn.PlaceList.add(P_TL3);

        DataCar P_M2 = new DataCar();
        P_M2.SetName("P_M2");
        pn.PlaceList.add(P_M2);


        // ----------------------------------------------------------------------------
        // ----------------------------Exit lane 1-------------------------------------
        // ----------------------------------------------------------------------------

        DataCarQueue P_O7 = new DataCarQueue(); //p17.Printable = false;
        P_O7.Value.Size = 3;
        P_O7.SetName("P_O7");
        pn.PlaceList.add(P_O7);

        DataCar P_O8 = new DataCar(); //p18.Printable = false;
        P_O8.SetName("P_O8");
        pn.PlaceList.add(P_O8);

        // ----------------------------------------------------------------------------
        // ----------------------------Exit lane 2-------------------------------------
        // ----------------------------------------------------------------------------

        DataCarQueue P_O9 = new DataCarQueue(); //p17.Printable = false;
        P_O9.Value.Size = 3;
        P_O9.SetName("P_O9");
        pn.PlaceList.add(P_O9);

        DataCar P_O10 = new DataCar(); //p18.Printable = false;
        P_O10.SetName("P_O10");
        pn.PlaceList.add(P_O10);


        // -------------------------------------------------------------------------------------------
        // --------------------------------Intersection1-----------------------------------------------
        // -------------------------------------------------------------------------------------------

        DataCarQueue P_INT1 = new DataCarQueue();
        P_INT1.Value.Size = 3;
        P_INT1.SetName("P_INT1");
        pn.PlaceList.add(P_INT1);

        // T_I1 ------------------------------------------------
        PetriTransition T_I1 = new PetriTransition(pn);
        T_I1.TransitionName = "T_I1";
        T_I1.InputPlaceName.add("P_I1");
        T_I1.InputPlaceName.add("P_I2");

        Condition T1Ct1 = new Condition(T_I1, "P_I1", TransitionCondition.NotNull);
        Condition T1Ct2 = new Condition(T_I1, "P_I2", TransitionCondition.CanAddCars);
        T1Ct1.SetNextCondition(LogicConnector.AND, T1Ct2);

        GuardMapping grdT1 = new GuardMapping();
        grdT1.condition = T1Ct1;
        grdT1.Activations.add(new Activation(T_I1, "P_I1", TransitionOperation.AddElement, "P_I2"));
        T_I1.GuardMappingList.add(grdT1);

        Condition T1Ct3 = new Condition(T_I1, "P_I1", TransitionCondition.NotNull);
        Condition T1Ct4 = new Condition(T_I1, "P_I2", TransitionCondition.CanNotAddCars);
        T1Ct3.SetNextCondition(LogicConnector.AND, T1Ct4);

        GuardMapping grdT1_1 = new GuardMapping();
        grdT1_1.condition = T1Ct3;
        grdT1_1.Activations.add(new Activation(T_I1, "full", TransitionOperation.SendOverNetwork, "OP1"));
        grdT1_1.Activations.add(new Activation(T_I1, "P_I1", TransitionOperation.Copy, "P_I1"));
        T_I1.GuardMappingList.add(grdT1_1);

        T_I1.Delay = 0;
        pn.Transitions.add(T_I1);

        // T_I2 ------------------------------------------------
        PetriTransition T_I2 = new PetriTransition(pn);
        T_I2.TransitionName = "T_I2";
        T_I2.InputPlaceName.add("P_I2");
        T_I2.InputPlaceName.add("P_TL1");

        Condition T2Ct1 = new Condition(T_I2, "P_TL1", TransitionCondition.Equal, "green");
        Condition T2Ct2 = new Condition(T_I2, "P_I2", TransitionCondition.HaveCar);
        T2Ct1.SetNextCondition(LogicConnector.AND, T2Ct2);

        GuardMapping grdT2 = new GuardMapping();
        grdT2.condition = T2Ct1;
        grdT2.Activations.add(new Activation(T_I2, "P_I2", TransitionOperation.PopElementWithoutTarget, "P_I3"));
        grdT2.Activations.add(new Activation(T_I2, "P_TL1", TransitionOperation.Move, "P_TL1"));

        T_I2.GuardMappingList.add(grdT2);

        T_I2.Delay = 0;
        pn.Transitions.add(T_I2);

        // T_I4 ------------------------------------------------
        PetriTransition T_I4 = new PetriTransition(pn);
        T_I4.TransitionName = "T_I4";
        T_I4.InputPlaceName.add("P_I4");
        T_I4.InputPlaceName.add("P_I5");

        Condition T3Ct1 = new Condition(T_I4, "P_I4", TransitionCondition.NotNull);
        Condition T3Ct2 = new Condition(T_I4, "P_I5", TransitionCondition.CanAddCars);
        T3Ct1.SetNextCondition(LogicConnector.AND, T3Ct2);

        GuardMapping grdT3 = new GuardMapping();
        grdT3.condition = T3Ct1;
        grdT3.Activations.add(new Activation(T_I4, "P_I4", TransitionOperation.AddElement, "P_I5"));
        T_I4.GuardMappingList.add(grdT3);

        Condition T3Ct3 = new Condition(T_I4, "P_I4", TransitionCondition.NotNull);
        Condition T3Ct4 = new Condition(T_I4, "P_I5", TransitionCondition.CanNotAddCars);
        T3Ct3.SetNextCondition(LogicConnector.AND, T3Ct4);

        GuardMapping grdT3_1 = new GuardMapping();
        grdT3_1.condition = T3Ct3;
        grdT3_1.Activations.add(new Activation(T_I4, "full", TransitionOperation.SendOverNetwork, "OP2"));
        grdT3_1.Activations.add(new Activation(T_I4, "P_I4", TransitionOperation.Copy, "P_I4"));
        T_I4.GuardMappingList.add(grdT3_1);

        T_I4.Delay = 0;
        pn.Transitions.add(T_I4);

        // T_I5 ------------------------------------------------
        PetriTransition T_I5 = new PetriTransition(pn);
        T_I5.TransitionName = "T_I5";
        T_I5.InputPlaceName.add("P_I5");
        T_I5.InputPlaceName.add("P_TL2");

        Condition T4Ct1 = new Condition(T_I5, "P_TL2", TransitionCondition.Equal, "green");
        Condition T4Ct2 = new Condition(T_I5, "P_I5", TransitionCondition.HaveCar);
        T4Ct1.SetNextCondition(LogicConnector.AND, T4Ct2);

        GuardMapping grdT4 = new GuardMapping();
        grdT4.condition = T4Ct1;
        grdT4.Activations.add(new Activation(T_I5, "P_I5", TransitionOperation.PopElementWithoutTarget, "P_I6"));
        grdT4.Activations.add(new Activation(T_I5, "P_TL2", TransitionOperation.Move, "P_TL2"));
        T_I5.GuardMappingList.add(grdT2);

        T_I5.Delay = 0;
        pn.Transitions.add(T_I5);

        // T_M5 ------------------------------------------------
        PetriTransition T_M5 = new PetriTransition(pn);
        T_M5.TransitionName = "T_M5";
        T_M5.InputPlaceName.add("P_M3");
        T_M5.InputPlaceName.add("P_TL4");

        Condition T6Ct1 = new Condition(T_M5, "P_TL4", TransitionCondition.Equal, "green");
        Condition T6Ct2 = new Condition(T_M5, "P_M3", TransitionCondition.HaveCar);
        T6Ct1.SetNextCondition(LogicConnector.AND, T6Ct2);

        GuardMapping grdT6 = new GuardMapping();
        grdT6.condition = T6Ct1;
        grdT6.Activations.add(new Activation(T_M5, "P_M3", TransitionOperation.PopElementWithoutTarget, "P_M4"));
        grdT6.Activations.add(new Activation(T_M5, "P_TL4", TransitionOperation.Move, "P_TL4"));
        T_M5.GuardMappingList.add(grdT6);

        T_M5.Delay = 0;
        pn.Transitions.add(T_M5);

        // T_O2----------------------------------------------------------------

        PetriTransition T_O2 = new PetriTransition(pn);
        T_O2.TransitionName = "T_O2";
        T_O2.InputPlaceName.add("P_O1");

        Condition T9Ct1 = new Condition(T_O2, "P_O1", TransitionCondition.HaveCar);

        GuardMapping grdT9 = new GuardMapping();
        grdT9.condition = T9Ct1;
        grdT9.Activations.add(new Activation(T_O2, "P_O1", TransitionOperation.PopElementWithoutTarget, "P_O2"));
        T_O2.GuardMappingList.add(grdT9);

        T_O2.Delay = 0;
        pn.Transitions.add(T_O2);

        // T_O6----------------------------------------------------------------

        PetriTransition T_O6 = new PetriTransition(pn);
        T_O6.TransitionName = "T_O6";
        T_O6.InputPlaceName.add("P_O5");

        Condition T10Ct1 = new Condition(T_O6, "P_O5", TransitionCondition.HaveCar);

        GuardMapping grdT10 = new GuardMapping();
        grdT10.condition = T10Ct1;
        grdT10.Activations.add(new Activation(T_O6, "P_O5", TransitionOperation.PopElementWithoutTarget, "P_O6"));
        T_O6.GuardMappingList.add(grdT10);

        T_O6.Delay = 0;
        pn.Transitions.add(T_O6);

        // T_O4-----------------------------------------------------

        PetriTransition T_O4 = new PetriTransition(pn);
        T_O4.TransitionName = "T_O4";
        T_O4.InputPlaceName.add("P_O3");

        Condition T_O4Ct1 = new Condition(T_O4, "P_O3", TransitionCondition.HaveCar);

        GuardMapping grdT_O4 = new GuardMapping();
        grdT_O4.condition = T_O4Ct1;
        grdT_O4.Activations.add(new Activation(T_O4, "P_O3", TransitionOperation.PopElementWithoutTarget, "P_O4"));
        T_O4.GuardMappingList.add(grdT_O4);

        T_O4.Delay = 0;
        pn.Transitions.add(T_O4);

        // T_I3------------------------------------------------
        PetriTransition T_I3 = new PetriTransition(pn);
        T_I3.TransitionName = "T_I3";
        T_I3.InputPlaceName.add("P_I3");
        T_I3.InputPlaceName.add("P_INT1");

        Condition T13Ct1 = new Condition(T_I3, "P_I3", TransitionCondition.NotNull);
        Condition T13Ct2 = new Condition(T_I3, "P_INT1", TransitionCondition.CanAddCars);
        T13Ct1.SetNextCondition(LogicConnector.AND, T13Ct2);

        GuardMapping grdT13 = new GuardMapping();
        grdT13.condition = T13Ct1;
        grdT13.Activations.add(new Activation(T_I3, "P_I3", TransitionOperation.AddElement, "P_INT1"));
        T_I3.GuardMappingList.add(grdT13);

        T_I3.Delay = 0;
        pn.Transitions.add(T_I3);

        // T_O1-----------------------------------------------------------
        PetriTransition T_O1 = new PetriTransition(pn);
        T_O1.TransitionName = "T_O1";
        T_O1.InputPlaceName.add("P_INT1");
        T_O1.InputPlaceName.add("P_O1");

        Condition T14Ct1 = new Condition(T_O1, "P_INT1", TransitionCondition.HaveCarForMe);
        Condition T14Ct2 = new Condition(T_O1, "P_O1", TransitionCondition.CanAddCars);
        T14Ct1.SetNextCondition(LogicConnector.AND, T14Ct2);

        GuardMapping grdT14 = new GuardMapping();
        grdT14.condition = T14Ct1;
        grdT14.Activations.add(new Activation(T_O1, "P_INT1", TransitionOperation.PopElementWithTargetToQueue, "P_O1"));
        T_O1.GuardMappingList.add(grdT14);

        T_O1.Delay = 2;
        pn.Transitions.add(T_O1);

        // T_I6------------------------------------------------
        PetriTransition T_I6 = new PetriTransition(pn);
        T_I6.TransitionName = "T_I6";
        T_I6.InputPlaceName.add("P_I6");
        T_I6.InputPlaceName.add("P_INT1");

        Condition T15Ct1 = new Condition(T_I6, "P_I6", TransitionCondition.NotNull);
        Condition T15Ct2 = new Condition(T_I6, "P_INT1", TransitionCondition.CanAddCars);
        T15Ct1.SetNextCondition(LogicConnector.AND, T15Ct2);

        GuardMapping grdT15 = new GuardMapping();
        grdT15.condition = T15Ct1;
        grdT15.Activations.add(new Activation(T_I6, "P_I6", TransitionOperation.AddElement, "P_INT1"));
        T_I6.GuardMappingList.add(grdT15);

        T_I6.Delay = 0;
        pn.Transitions.add(T_I6);

        // T_O5-----------------------------------------------------------
        PetriTransition T_O5 = new PetriTransition(pn);
        T_O5.TransitionName = "T_O5";
        T_O5.InputPlaceName.add("P_INT1");
        T_O5.InputPlaceName.add("P_O5");

        Condition T16Ct1 = new Condition(T_O5, "P_INT1", TransitionCondition.HaveCarForMe);
        Condition T16Ct2 = new Condition(T_O5, "P_O5", TransitionCondition.CanAddCars);
        T16Ct1.SetNextCondition(LogicConnector.AND, T16Ct2);

        GuardMapping grdT16 = new GuardMapping();
        grdT16.condition = T16Ct1;
        grdT16.Activations.add(new Activation(T_O5, "P_INT1", TransitionOperation.PopElementWithTargetToQueue, "P_O5"));
        T_O5.GuardMappingList.add(grdT16);

        T_O5.Delay = 2;
        pn.Transitions.add(T_O5);

        // T_O3--------------------------------------------------------
        PetriTransition T_O3 = new PetriTransition(pn);
        T_O3.TransitionName = "T_O3";
        T_O3.InputPlaceName.add("P_INT1");
        T_O3.InputPlaceName.add("P_O3");

        Condition T18Ct1 = new Condition(T_O3, "P_INT1", TransitionCondition.HaveCarForMe);

        GuardMapping grdT18 = new GuardMapping();
        grdT18.condition = T18Ct1;
        grdT18.Activations.add(new Activation(T_O3, "P_INT1", TransitionOperation.PopElementWithTarget, "P_O3"));
        T_O3.GuardMappingList.add(grdT18);

        T_O3.Delay = 2;
        pn.Transitions.add(T_O3);

        // T_M6------------------------------------------------
        PetriTransition T_M6 = new PetriTransition(pn);
        T_M6.TransitionName = "T_M6";
        T_M6.InputPlaceName.add("P_M4");
        T_M6.InputPlaceName.add("P_INT1");

        Condition T_M6_Ct1 = new Condition(T_M6, "P_M4", TransitionCondition.NotNull);
        Condition T_M6_Ct2 = new Condition(T_M6, "P_INT1", TransitionCondition.CanAddCars);
        T_M6_Ct1.SetNextCondition(LogicConnector.AND, T_M6_Ct2);

        GuardMapping grdT_M6 = new GuardMapping();
        grdT_M6.condition = T_M6_Ct1;
        grdT_M6.Activations.add(new Activation(T_M6, "P_M4", TransitionOperation.AddElement, "P_INT1"));
        T_M6.GuardMappingList.add(grdT_M6);

        T_M6.Delay = 0;
        pn.Transitions.add(T_M6);

        // T_M1--------------------------------------------------------

        PetriTransition T_M1 = new PetriTransition(pn);
        T_M1.TransitionName = "T_M1";
        T_M1.InputPlaceName.add("P_INT1");
        T_M1.InputPlaceName.add("P_M1");

        Condition T_M1_Ct1 = new Condition(T_M1, "P_INT1", TransitionCondition.HaveCarForMe);

        GuardMapping grdT_M1 = new GuardMapping();
        grdT_M1.condition = T_M1_Ct1;
        grdT_M1.Activations.add(new Activation(T_M1, "P_INT1", TransitionOperation.PopElementWithTargetToQueue, "P_M1"));
        T_M1.GuardMappingList.add(grdT_M1);

        T_M1.Delay = 2;
        pn.Transitions.add(T_M1);

        // -------------------------------------------------------------------------------------------
        // --------------------------------Intersection2-----------------------------------------------
        // -------------------------------------------------------------------------------------------

        DataCarQueue P_INT2 = new DataCarQueue();
        P_INT2.Value.Size = 3;
        P_INT2.SetName("P_INT2");
        pn.PlaceList.add(P_INT2);

        // T_M2 ------------------------------------------------
        PetriTransition T_M2 = new PetriTransition(pn);
        T_M2.TransitionName = "T_M2";
        T_M2.InputPlaceName.add("P_M1");
        T_M2.InputPlaceName.add("P_TL3");

        Condition T_M2_Ct1 = new Condition(T_M2, "P_TL3", TransitionCondition.Equal, "green");
        Condition T_M2_Ct2 = new Condition(T_M2, "P_M1", TransitionCondition.HaveCar);
        T_M2_Ct1.SetNextCondition(LogicConnector.AND, T_M2_Ct2);

        GuardMapping grdT_M2 = new GuardMapping();
        grdT_M2.condition = T_M2_Ct1;
        grdT_M2.Activations.add(new Activation(T_M2, "P_M1", TransitionOperation.PopElementWithoutTarget, "P_M2"));
        grdT_M2.Activations.add(new Activation(T_M2, "P_TL3", TransitionOperation.Move, "P_TL3"));
        T_M2.GuardMappingList.add(grdT_M2);

        T_M2.Delay = 0;
        pn.Transitions.add(T_M2);

        // T_I13 ------------------------------------------------
        PetriTransition T_I13 = new PetriTransition(pn);
        T_I13.TransitionName = "T_I13";
        T_I13.InputPlaceName.add("P_I13");
        T_I13.InputPlaceName.add("P_I14");

        Condition T_I13_Ct1 = new Condition(T_I13, "P_I13", TransitionCondition.NotNull);
        Condition T_I13_Ct2 = new Condition(T_I13, "P_I14", TransitionCondition.CanAddCars);
        T_I13_Ct1.SetNextCondition(LogicConnector.AND, T_I13_Ct2);

        GuardMapping grdT_I13 = new GuardMapping();
        grdT_I13.condition = T_I13_Ct1;
        grdT_I13.Activations.add(new Activation(T_I13, "P_I13", TransitionOperation.AddElement, "P_I14"));
        T_I13.GuardMappingList.add(grdT_I13);

        Condition T_I13_Ct3 = new Condition(T_I13, "P_I13", TransitionCondition.NotNull);
        Condition T_I13_Ct4 = new Condition(T_I13, "P_I14", TransitionCondition.CanNotAddCars);
        T_I13_Ct3.SetNextCondition(LogicConnector.AND, T_I13_Ct4);

        GuardMapping grdT_I13_1 = new GuardMapping();
        grdT_I13_1.condition = T_I13_Ct3;
        grdT_I13_1.Activations.add(new Activation(T_I13, "full", TransitionOperation.SendOverNetwork, "OP5"));
        grdT_I13_1.Activations.add(new Activation(T_I13, "P_I13", TransitionOperation.Copy, "P_I13"));
        T_I13.GuardMappingList.add(grdT_I13_1);

        T_I13.Delay = 0;
        pn.Transitions.add(T_I13);

        // T_I14 ------------------------------------------------
        PetriTransition T_I14 = new PetriTransition(pn);
        T_I14.TransitionName = "T_I14";
        T_I14.InputPlaceName.add("P_I14");
        T_I14.InputPlaceName.add("P_TL7");

        Condition T_I14_Ct1 = new Condition(T_I14, "P_TL7", TransitionCondition.Equal, "green");
        Condition T_I14_Ct2 = new Condition(T_I14, "P_I14", TransitionCondition.HaveCar);
        T_I14_Ct1.SetNextCondition(LogicConnector.AND, T_I14_Ct2);

        GuardMapping grdT_I14 = new GuardMapping();
        grdT_I14.condition = T_I14_Ct1;
        grdT_I14.Activations.add(new Activation(T_I14, "P_I14", TransitionOperation.PopElementWithoutTarget, "P_I15"));
        grdT_I14.Activations.add(new Activation(T_I14, "P_TL7", TransitionOperation.Move, "P_TL7"));
        T_I14.GuardMappingList.add(grdT_I14);

        T_I14.Delay = 0;
        pn.Transitions.add(T_I14);

        // T_I10 ------------------------------------------------
        PetriTransition T_I10 = new PetriTransition(pn);
        T_I10.TransitionName = "T_I10";
        T_I10.InputPlaceName.add("P_I10");
        T_I10.InputPlaceName.add("P_I11");

        Condition T7Ct1 = new Condition(T_I10, "P_I10", TransitionCondition.NotNull);
        Condition T7Ct2 = new Condition(T_I10, "P_I11", TransitionCondition.CanAddCars);
        T7Ct1.SetNextCondition(LogicConnector.AND, T7Ct2);

        GuardMapping grdT7 = new GuardMapping();
        grdT7.condition = T7Ct1;
        grdT7.Activations.add(new Activation(T_I10, "P_I10", TransitionOperation.AddElement, "P_I11"));
        T_I10.GuardMappingList.add(grdT7);

        Condition T7Ct3 = new Condition(T_I10, "P_I10", TransitionCondition.NotNull);
        Condition T7Ct4 = new Condition(T_I10, "P_I11", TransitionCondition.CanNotAddCars);
        T7Ct3.SetNextCondition(LogicConnector.AND, T7Ct4);

        GuardMapping grdT7_1 = new GuardMapping();
        grdT7_1.condition = T7Ct3;
        grdT7_1.Activations.add(new Activation(T_I10, "full", TransitionOperation.SendOverNetwork, "OP4"));
        grdT7_1.Activations.add(new Activation(T_I10, "P_I10", TransitionOperation.Copy, "P_I10"));
        T_I10.GuardMappingList.add(grdT7_1);

        T_I10.Delay = 0;
        pn.Transitions.add(T_I10);

        // T_I11 ------------------------------------------------
        PetriTransition T_I11 = new PetriTransition(pn);
        T_I11.TransitionName = "T_I11";
        T_I11.InputPlaceName.add("P_I11");
        T_I11.InputPlaceName.add("P_TL6");

        Condition T8Ct1 = new Condition(T_I11, "P_TL6", TransitionCondition.Equal, "green");
        Condition T8Ct2 = new Condition(T_I11, "P_I11", TransitionCondition.HaveCar);
        T6Ct1.SetNextCondition(LogicConnector.AND, T8Ct2);

        GuardMapping grdT8 = new GuardMapping();
        grdT8.condition = T8Ct1;
        grdT8.Activations.add(new Activation(T_I11, "P_I11", TransitionOperation.PopElementWithoutTarget, "P_I12"));
        grdT8.Activations.add(new Activation(T_I11, "P_TL6", TransitionOperation.Move, "P_TL6"));
        T_I11.GuardMappingList.add(grdT8);

        T_I11.Delay = 0;
        pn.Transitions.add(T_I11);

        // T_I7 ------------------------------------------------
        PetriTransition T_I7 = new PetriTransition(pn);
        T_I7.TransitionName = "T_I7";
        T_I7.InputPlaceName.add("P_I7");
        T_I7.InputPlaceName.add("P_I8");

        Condition T_I7_Ct1 = new Condition(T_I7, "P_I7", TransitionCondition.NotNull);
        Condition T_I7_Ct2 = new Condition(T_I7, "P_I8", TransitionCondition.CanAddCars);
        T_I7_Ct1.SetNextCondition(LogicConnector.AND, T_I7_Ct2);

        GuardMapping grdT_I7 = new GuardMapping();
        grdT_I7.condition = T_I7_Ct1;
        grdT_I7.Activations.add(new Activation(T_I7, "P_I7", TransitionOperation.AddElement, "P_I8"));
        T_I7.GuardMappingList.add(grdT_I7);

        Condition T_I7_Ct3 = new Condition(T_I7, "P_I7", TransitionCondition.NotNull);
        Condition T_I7_Ct4 = new Condition(T_I7, "P_I8", TransitionCondition.CanNotAddCars);
        T_I7_Ct3.SetNextCondition(LogicConnector.AND, T_I7_Ct4);

        GuardMapping grdT_I7_1 = new GuardMapping();
        grdT_I7_1.condition = T_I7_Ct3;
        grdT_I7_1.Activations.add(new Activation(T_I7, "full", TransitionOperation.SendOverNetwork, "OP3"));
        grdT_I7_1.Activations.add(new Activation(T_I7, "P_I7", TransitionOperation.Copy, "P_I7"));
        T_I7.GuardMappingList.add(grdT_I7_1);

        T_I7.Delay = 0;
        pn.Transitions.add(T_I7);

        // T_I8 ------------------------------------------------
        PetriTransition T_I8 = new PetriTransition(pn);
        T_I8.TransitionName = "T_I8";
        T_I8.InputPlaceName.add("P_I8");
        T_I8.InputPlaceName.add("P_TL5");

        Condition T_I8_Ct1 = new Condition(T_I8, "P_TL5", TransitionCondition.Equal, "green");
        Condition T_I8_Ct2 = new Condition(T_I8, "P_I8", TransitionCondition.HaveCar);
        T_I8_Ct1.SetNextCondition(LogicConnector.AND, T_I8_Ct2);

        GuardMapping grdT_I8 = new GuardMapping();
        grdT_I8.condition = T_I8_Ct1;
        grdT_I8.Activations.add(new Activation(T_I8, "P_I8", TransitionOperation.PopElementWithoutTarget, "P_I9"));
        grdT_I8.Activations.add(new Activation(T_I8, "P_TL5", TransitionOperation.Move, "P_TL5"));
        T_I8.GuardMappingList.add(grdT_I8);

        T_I8.Delay = 0;
        pn.Transitions.add(T_I8);

        // T_O8---------------------------------------------------------------
        PetriTransition T_O8 = new PetriTransition(pn);
        T_O8.TransitionName = "T_O8";
        T_O8.InputPlaceName.add("P_O7");

        Condition T_O8_Ct1 = new Condition(T_O8, "P_O7", TransitionCondition.HaveCar);

        GuardMapping grdT_O8 = new GuardMapping();
        grdT_O8.condition = T_O8_Ct1;
        grdT_O8.Activations.add(new Activation(T_O8, "P_O7", TransitionOperation.PopElementWithoutTarget, "P_O8"));
        T_O8.GuardMappingList.add(grdT_O8);

        T_O8.Delay = 0;
        pn.Transitions.add(T_O8);

        // T_O10---------------------------------------------------------------
        PetriTransition T_O10 = new PetriTransition(pn);
        T_O10.TransitionName = "T_O10";
        T_O10.InputPlaceName.add("P_O9");

        Condition T_O10_Ct1 = new Condition(T_O10, "P_O9", TransitionCondition.HaveCar);

        GuardMapping grdT_O10 = new GuardMapping();
        grdT_O10.condition = T_O10_Ct1;
        grdT_O10.Activations.add(new Activation(T_O10, "P_O9", TransitionOperation.PopElementWithoutTarget, "P_O10"));
        T_O10.GuardMappingList.add(grdT_O10);

        T_O10.Delay = 0;
        pn.Transitions.add(T_O10);

        // T_O9----------------------------------------------------------
        PetriTransition T_O9 = new PetriTransition(pn);
        T_O9.TransitionName = "T_O9";
        T_O9.InputPlaceName.add("P_INT2");
        T_O9.InputPlaceName.add("P_O9");

        Condition T_O9_Ct1 = new Condition(T_O9, "P_INT2", TransitionCondition.HaveCarForMe);
        Condition T_O9_Ct2 = new Condition(T_O9, "P_O9", TransitionCondition.CanAddCars);
        T_O9_Ct1.SetNextCondition(LogicConnector.AND, T_O9_Ct2);

        GuardMapping grdT_O9 = new GuardMapping();
        grdT_O9.condition = T_O9_Ct1;
        grdT_O9.Activations.add(new Activation(T_O9, "P_INT2", TransitionOperation.PopElementWithTargetToQueue, "P_O9"));
        T_O9.GuardMappingList.add(grdT_O9);

        T_O9.Delay = 2;
        pn.Transitions.add(T_O9);

        // T_O7----------------------------------------------------------
        PetriTransition T_O7 = new PetriTransition(pn);
        T_O7.TransitionName = "T_O7";
        T_O7.InputPlaceName.add("P_INT2");
        T_O7.InputPlaceName.add("P_O7");

        Condition T_O7_Ct1 = new Condition(T_O7, "P_INT2", TransitionCondition.HaveCarForMe);
        Condition T_O7_Ct2 = new Condition(T_O7, "P_O7", TransitionCondition.CanAddCars);
        T_O7_Ct1.SetNextCondition(LogicConnector.AND, T_O7_Ct2);

        GuardMapping grdT_O7 = new GuardMapping();
        grdT_O7.condition = T_O7_Ct1;
        grdT_O7.Activations.add(new Activation(T_O7, "P_INT2", TransitionOperation.PopElementWithTargetToQueue, "P_O7"));
        T_O7.GuardMappingList.add(grdT_O7);

        T_O7.Delay = 2;
        pn.Transitions.add(T_O7);

        // T_M3-----------------------------------------------
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

        // T_M4----------------------------------------------------------
        PetriTransition T_M4 = new PetriTransition(pn);
        T_M4.TransitionName = "T_M4";
        T_M4.InputPlaceName.add("P_INT2");
        T_M4.InputPlaceName.add("P_M3");

        Condition T_M4_Ct1 = new Condition(T_M4, "P_INT2", TransitionCondition.HaveCarForMe);

        GuardMapping grdT_M4 = new GuardMapping();
        grdT_M4.condition = T_M4_Ct1;
        grdT_M4.Activations.add(new Activation(T_M4, "P_INT2", TransitionOperation.PopElementWithTargetToQueue, "P_M3"));
        T_M4.GuardMappingList.add(grdT_M4);

        T_M4.Delay = 2;
        pn.Transitions.add(T_M4);

        // T_I15-----------------------------------------------
        PetriTransition T_I15 = new PetriTransition(pn);
        T_I15.TransitionName = "T_I15";
        T_I15.InputPlaceName.add("P_I15");
        T_I15.InputPlaceName.add("P_INT2");

        Condition T17Ct1 = new Condition(T_I15, "P_I15", TransitionCondition.NotNull);
        Condition T17Ct2 = new Condition(T_I15, "P_INT2", TransitionCondition.CanAddCars);
        T17Ct1.SetNextCondition(LogicConnector.AND, T17Ct2);

        GuardMapping grdT17 = new GuardMapping();
        grdT17.condition = T17Ct1;
        grdT17.Activations.add(new Activation(T_I15, "P_I15", TransitionOperation.AddElement, "P_INT2"));
        T_I15.GuardMappingList.add(grdT17);

        T_I15.Delay = 0;
        pn.Transitions.add(T_I15);

        // T_I12-----------------------------------------------
        PetriTransition T_I12 = new PetriTransition(pn);
        T_I12.TransitionName = "T_I12";
        T_I12.InputPlaceName.add("P_I12");
        T_I12.InputPlaceName.add("P_INT2");

        Condition T19Ct1 = new Condition(T_I12, "P_I12", TransitionCondition.NotNull);
        Condition T19Ct2 = new Condition(T_I12, "P_INT2", TransitionCondition.CanAddCars);
        T19Ct1.SetNextCondition(LogicConnector.AND, T19Ct2);

        GuardMapping grdT19 = new GuardMapping();
        grdT19.condition = T19Ct1;
        grdT19.Activations.add(new Activation(T_I12, "P_I12", TransitionOperation.PopElementWithoutTarget, "P_INT2"));
        T_I12.GuardMappingList.add(grdT19);

        T_I12.Delay = 0;
        pn.Transitions.add(T_I12);

        // T_I9-----------------------------------------------
        PetriTransition T_I9 = new PetriTransition(pn);
        T_I9.TransitionName = "T_I9";
        T_I9.InputPlaceName.add("P_I9");
        T_I9.InputPlaceName.add("P_INT2");

        Condition T_I9_Ct1 = new Condition(T_I9, "P_I9", TransitionCondition.NotNull);
        Condition T_I9_Ct2 = new Condition(T_I9, "P_INT2", TransitionCondition.CanAddCars);
        T_I9_Ct1.SetNextCondition(LogicConnector.AND, T_I9_Ct2);

        GuardMapping grdT_I9 = new GuardMapping();
        grdT_I9.condition = T_I9_Ct1;
        grdT_I9.Activations.add(new Activation(T_I9, "P_I9", TransitionOperation.PopElementWithoutTarget, "P_INT2"));
        T_I9.GuardMappingList.add(grdT_I9);

        T_I9.Delay = 0;
        pn.Transitions.add(T_I9);

        // -------------------------------------------------------------------------------------
        // ----------------------------PNStart-------------------------------------------------
        // -------------------------------------------------------------------------------------

        System.out.println("Lanes intersection started \n ------------------------------");
        pn.Delay = 2000;
        // pn.Start();

        PetriNetWindow frame = new PetriNetWindow(false);
        frame.petriNet = pn;
        frame.setVisible(true);
    }
}
