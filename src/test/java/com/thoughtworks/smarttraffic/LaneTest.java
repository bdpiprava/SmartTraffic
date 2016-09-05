package com.thoughtworks.smarttraffic;

import com.pi4j.io.gpio.Pin;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

/**
 * Created by Bhupendrakumar Piprava on 9/5/16.
 */
public class LaneTest {

    @Test
    public void testTrafficPeakLevel() {
        Lane lane = new Lane(25);
        UltrasonicSensor sensor = Mockito.mock(UltrasonicSensor.class);
        lane.addSensor(sensor);


        Float[][] readings = new Float[][]{
                {3199.5938f, 139.56995f, 354.41205f, 353.204f, 355.3308f, 354.03772f, 352.3533f, 353.62936f, 683.3534f, 354.03772f, 357.5257f, 354.5652f, 356.21558f, 2751.84f, 353.204f, 358.25732f, 355.34784f, 354.08878f, 355.73917f, 354.4801f, 354.05475f, 99.517815f, 353.204f, 353.204f, 359.56744f, 99.10946f, 353.6464f, 107.14031f, 354.9395f, 358.37643f, 357.0833f, 355.02457f, 355.38187f, 357.69586f, 100.81091f, 353.23804f, 353.25504f, 104.21381f, 359.5504f, 354.15683f, 356.2496f, 357.1003f, 100.3345f, 354.1398f, 354.9565f, 112.60196f, 124.376f, 100.84494f, 107.565674f, 354.10577f, 355.3308f, 3944.982f, 99.94318f, 360.4692f, 122.67455f, 2165.6057f},
                {355.85828f, 353.6464f, 352.8297f, 101.21926f, 2635.478f, 99.99422f, 360.77548f, 356.62393f, 353.22104f, 353.6634f, 355.39886f, 107.14031f, 359.1931f, 357.0493f, 3921.264f, 16.946442f, 18.869081f, 19.43056f, 353.0679f, 17.422848f, 16.487051f, 354.10577f, 357.47464f, 354.9395f, 357.50867f, 355.7732f, 13.849803f, 354.9055f, 16.418993f, 353.22104f, 14.717543f, 15.976616f, 3941.2388f, 19.447573f, 14.019948f, 15.279022f, 357.883f, 17.456879f, 16.436008f, 21.234097f, 359.60147f, 354.05475f, 356.64096f, 356.99826f, 107.089264f, 15.125891f, 14.122036f, 15.602297f, 100.776886f, 356.62393f, 354.9395f, 109.199066f, 185.20284f, 101.15121f, 3942.566f, 22.169893f, 357.50867f, 356.65796f, 356.18155f, 362.95334f, 181.93605f, 355.80722f, 357.49167f, 11.791048f, 353.23804f, 107.089264f, 355.80722f, 356.21558f, 354.9565f, 353.25504f, 353.62936f, 102.95474f, 12.505658f, 138.42998f, 3915.3088f, 101.59358f, 357.49167f, 3936.985f, 13.985919f, 354.9565f, 178.9415f, 354.54816f, 357.0663f, 3987.7563f, 14.700528f, 19.566675f, 105.932274f, 99.92616f, 108.4164f, 34.25019f, 3942.0215f, 16.929428f, 356.19858f, 201.7239f, 104.1968f, 1852.1816f, 107.42955f, 547.91797f, 109.233086f, 1775.8204f, 11.41673f, 11.961194f, 2329.9316f, 355.34784f, 103.78845f, 388.16882f, 3948.572f, 12.62476f, 16.52108f, 353.68042f, 354.10577f, 12.199397f, 12.675803f, 354.03772f, 354.54816f, 293.89148f, 358.73373f, 351.5536f, 169.0901f, 354.53116f, 217.00294f, 10.446903f, 13.220267f, 356.19858f, 101.20225f, 3915.7173f, 31.493841f, 354.08878f, 15.891543f, 10.923309f, 13.033107f, 354.08878f, 356.19858f, 359.1591f, 228.4537f, 3946.5984f, 11.093454f, 14.053978f, 19.345488f, 20.63859f, 354.08878f, 354.08878f, 354.08878f, 352.8467f, 97.833374f, 198.11684f, 354.9565f, 355.34784f, 11.382701f, 18.086414f, 104.162766f, 355.36484f, 29.14584f, 100.38555f, 357.50867f, 354.87143f, 177.9887f, 17.746124f, 14.59844f, 221.08643f, 357.0493f, 354.51413f, 98.565f, 106.23854f, 178.38002f, 33.008133f, 354.4801f, 24.143576f},
                {21.421257f, 219.5381f, 356.19858f, 354.08878f, 3942.566f, 28.635403f, 354.46307f, 353.68042f, 102.86967f, 107.157326f, 12.77789f, 14.3091955f, 105.52394f, 357.4406f, 1453.1064f, 355.79022f, 177.24005f, 21.046938f, 19.872936f, 359.58444f, 15.585283f, 362.9363f, 170.80858f, 181.868f, 33.72274f, 3948.0276f, 15.8405f, 16.555109f, 14.394267f, 355.34784f, 354.51413f, 357.0663f, 354.9225f, 29.435085f, 354.08878f, 101.253296f, 3949.61f, 14.683514f, 354.54816f, 11.7400055f, 13.628614f, 16.793312f, 355.34784f, 355.39886f, 352.77866f, 356.62393f, 107.957f, 353.5443f, 353.16998f, 354.1398f, 354.54816f, 356.19858f, 101.236275f, 156.44833f, 356.64096f, 100.402565f, 353.16998f, 120.41163f, 100.84494f, 355.7562f, 106.28959f, 3953.7104f, 100.81091f, 353.187f, 3916.7893f, 112.0575f, 354.9225f, 354.5652f, 105.45587f, 354.39502f, 352.77866f, 354.88846f, 105.42185f, 353.22104f, 320.12784f, 353.187f, 181.23846f, 354.07175f, 18.664906f, 14.785602f, 12.879976f, 13.373397f, 13.475485f, 14.002934f, 14.29218f, 14.343224f, 14.649485f, 14.479341f, 14.904703f, 14.785602f, 16.36795f, 22.697344f, 355.84125f, 354.03772f, 102.46132f, 3947.0408f, 30.353868f, 23.32688f, 18.528791f, 16.248848f, 15.908558f, 15.959601f, 18.171486f, 24.398794f, 354.07175f, 354.49713f, 354.9225f, 354.49713f, 353.6464f, 200.03949f, 217.81963f, 354.88846f, 188.0953f, 21.217083f, 17.405834f, 15.227978f, 14.411282f, 15.364094f, 17.065544f, 21.829605f, 99.22857f, 226.08867f, 353.6464f, 296.06934f, 353.22104f, 354.54816f, 353.6464f, 354.4801f, 357.0323f, 354.05475f, 356.9302f, 356.14752f, 105.830185f, 354.08878f, 102.46132f, 30.16671f, 19.685776f, 15.125891f, 14.615457f, 15.176934f, 19.95801f, 354.39502f, 352.77866f, 100.36854f, 356.96423f, 105.438866f, 352.77866f, 356.96423f, 354.51413f, 354.9055f, 353.95264f, 353.22104f, 353.15298f, 110.04979f, 183.29721f, 356.16452f, 14.768586f, 14.275166f, 352.7106f, 17.899254f, 24.041489f, 355.3138f, 354.05475f, 102.52938f, 356.79407f, 108.38236f, 353.15298f, 357.81494f, 357.86597f, 355.24576f, 358.68268f, 101.21926f, 107.58269f, 167.03136f, 15.210964f, 11.8420925f, 12.845947f, 15.142904f, 100.776886f, 359.057f, 353.98666f, 356.96423f, 100.351524f, 357.3896f, 281.94727f, 354.07175f, 354.05475f},
                {3947.6533f, 99.10946f, 354.49713f, 20.706646f, 15.483195f, 354.4801f, 353.62936f, 360.38412f, 353.59534f, 354.1398f, 356.2326f, 99.92616f, 355.7732f, 2301.5857f, 353.6464f, 357.0323f, 355.38187f, 354.51413f, 359.56744f, 3951.1924f, 99.10946f, 304.23627f, 353.6634f, 354.99054f, 358.32538f, 356.60693f, 355.38187f, 353.6634f, 3682.2612f, 101.98491f, 112.1766f, 359.61847f, 353.62936f, 354.07175f, 112.63599f, 354.9565f, 100.36854f, 354.87143f, 102.49535f, 356.2496f, 353.6464f, 358.3424f, 3683.8604f, 358.29135f, 352.8297f, 357.91702f, 353.6464f, 353.6464f, 353.68042f, 353.68042f, 359.5504f, 272.16394f, 106.731964f, 359.56744f, 357.0833f, 104.97946f, 353.22104f, 355.3308f, 354.10577f, 353.68042f, 356.2326f, 353.16998f, 103.36309f, 354.1228f, 354.85443f, 140.0974f, 353.187f, 358.71674f, 106.28959f, 110.0668f, 352.31924f, 355.6711f, 354.07175f, 355.79022f, 362.11963f, 353.6634f, 101.69567f, 353.204f, 353.57834f, 101.9679f, 352.76163f, 357.91702f, 360.40115f, 357.0493f, 357.47464f, 353.11896f, 353.22104f, 353.22104f, 110.04979f, 103.43115f, 104.24784f, 353.187f, 358.30838f, 143.46626f, 136.77957f, 355.3138f, 355.34784f, 1083.7556f, 354.07175f, 354.87143f, 102.920715f, 77.46702f, 1488.4966f, 355.79022f, 354.08878f, 361.2859f, 354.05475f, 359.1591f, 354.9395f, 357.0663f, 354.9395f, 355.7562f, 354.85443f, 2048.1716f, 175.0622f, 359.12506f, 355.36484f, 106.28959f, 354.05475f, 354.51413f, 2579.2112f, 355.72214f, 3912.9097f, 99.5008f, 393.83466f, 98.70112f, 354.08878f, 104.639175f, 357.47464f, 208.46167f, 128.49352f, 194.57782f, 13.050122f, 199.478f, 356.14752f, 15.585283f, 3937.7168f, 99.10946f, 356.5899f, 3953.8296f, 103.32906f, 3943.3828f, 16.487051f, 355.73917f, 18.681921f, 19.787865f, 357.86597f, 137.66432f, 353.59534f, 354.88846f, 103.754425f, 108.84176f, 103.31204f, 3952.5195f, 354.9055f, 358.2403f, 15.193949f, 16.487051f, 355.7732f, 354.42905f, 17.69508f, 360.36713f, 102.9037f}
        };

        for (Float[] reading : readings) {
            Mockito.when(sensor.getReadings()).thenReturn(Arrays.asList(reading));
            Mockito.when(sensor.getRoadDistance()).thenReturn(300f);
            System.out.println("Is peak: " + lane.isTrafficAtPeak());
        }
    }

}