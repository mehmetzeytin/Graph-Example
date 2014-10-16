import java.util.*;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlAdapter;


public class MatrixAdapter extends XmlAdapter<MatrixAdapter.AdaptedMatrix, int [][]> {
	
	public static class AdaptedMatrix {
		@XmlElement(name = "row")
		public List<AdaptedRow> rows;
	} 
	
	public static class AdaptedRow {
		@XmlValue
		public int[] row;
	}

	@Override
	public AdaptedMatrix marshal(int[][] matrix) throws Exception {
        AdaptedMatrix adaptedMatrix = new AdaptedMatrix();
        adaptedMatrix.rows = new ArrayList<AdaptedRow>(matrix.length);
        for(int[] row : matrix) {
            AdaptedRow adaptedRow = new AdaptedRow();
            adaptedRow.row = row;
            adaptedMatrix.rows.add(adaptedRow);
        }
        return adaptedMatrix;
    }

    @Override
    public int[][] unmarshal(AdaptedMatrix adaptedMatrix) throws Exception {
        List<AdaptedRow> adaptedRows = adaptedMatrix.rows;
        int[][] matrix = new int[adaptedRows.size()][];
        for(int x=0; x<adaptedRows.size(); x++) {
            matrix[x] = adaptedRows.get(x).row;
        }
        return matrix;
    }

}
