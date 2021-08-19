
public class RomanNumeralConverter {

	public RomanNumeralConverter() {
	}
	
	/**
	*	This method uses a greedy solution of always taking the "largest" available
	* Roman numeral and adding it to the solution to convert an integer value in
	* the range of 1-9999 to Roman Numerals.
	*
	* @param x the integer value to be converted
	* @return	roman the given value in Roman Numerals
	*/
	public String toRoman(int x) {

		/* Check to see if the value is within the given range of 1-9999. If it is not, return a String stating
		 * that the value is outside the acceptable range.*/
		if ( x < 1 || x > 9999) {
			return x + " is not within acceptable range of 1-9999.";
		}

		/* Else the value can be represented as Roman numerals and we proceed to the conversion.*/
		else {

			/* Save initial value for printing result*/
			int y = x;


			/* We now initialize 2 arrays, one that contains all the possible Roman numerals we might print
			 * and the other contains their values. The 2 arrays have the corresponding value store at the same
			 * value index. Example, "I" is at index 0 in the romanNumerals array, and its value 1 is stored
			 * at index 0 in the intValues array. We can use these parallel arrays to select the correct value. */
			String romanNumerals[] = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M",
					"I\u0305V\u0305", "V\u0305", "I\u0305X\u0305"};
			int intValues[] = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000,
					4000, 5000, 9000};

			/* Initialize the String roman to store the converted String based on the integer
			 * argument passed through the method. */
			String roman = "";

			/* We want to make the greedy choice of the largest available Roman numeral each time
			 * we append a value to the final answer. To do this we must track the index starting from the
			 * largest available point, which is the length of the romanNumerals array - 1. */
			int index = romanNumerals.length - 1;

			/* As stated above we want to make the greedy choice each time we can choose to add a value. Always
			 * choosing the largest available item will always result in the correct substring and thus the correct
			 * string overall. For example, if we want to represent 1101 we start with the largest value M = 1000.
			 * That leaves us with M and a remainder of 101 to represent. The next largest numeral available is C = 100,
			 * so we append C to M yielding MC and a remainder of 01. The largest value left is I = 1, and after
			 * appending that we have MCI, the correct final result.
			 *
			 * The first while loop controls for the end condition, when the remainder x is no longer positive and
			 * the process must terminate. The inside loop and index decrement build the final result. If the value
			 * of the argument x <= the value representing a Roman numeral in the intValues array, we can append
			 * the corresponding value to the answer roman and subtract that value from the argument and check again.
			 * If the argument x is > the value of intValues at the current index, then we decrement the index
			 * to check the next largest available value as long as the argument x remains positive. */
			while (x > 0) {
				while (intValues[index] <= x) {
					roman += romanNumerals[index];
					x -= intValues[index];
				}
				index--;
			}

			/* When the above procedure completes and the argument x is no longer positive we return the resulting
			 * string. We use the variable y which contains the initial argument passed. */
		return  y + " is " + roman + " in Roman numerals.";
		}
	}
}
