using System;
using System.Collections.Generic;
using System.Globalization;
using System.IO;
using System.Linq;
using System.Text;

namespace Lawl
{
    class Program
    {
        public object Solve()
        {
            for (int n = ReadInt(); n > 0; n--)
            {
                int a = ReadInt(), b = ReadInt();
                long p = ReadLong();
                writer.WriteLine(1L * a * b == p ? "POSSIBLE DOUBLE SIGMA" : "16 BIT S/W ONLY");
            }

            return null;
        }


        #region I/O
        protected static TextReader reader;
        protected static TextWriter writer;

        static void Main(string[] args)
        {
            reader = Console.In;
            writer = new StreamWriter(Console.OpenStandardOutput());

            Program solver = new Program();

            try
            {
                object result = solver.Solve();
                if (result != null)
                {
                    writer.WriteLine(result);
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex);
                throw;
            }
            reader.Close();
            writer.Close();
        }

        #endregion

        #region Read/Write

        private static Queue<string> currentLineTokens = new Queue<string>();

        private static string[] ReadAndSplitLine()
        {
            return reader.ReadLine().Split(new[] { ' ', '\t' }, StringSplitOptions.RemoveEmptyEntries);
        }

        public static string ReadToken()
        {
            while (currentLineTokens.Count == 0)
                currentLineTokens = new Queue<string>(ReadAndSplitLine());
            return currentLineTokens.Dequeue();
        }

        public static int ReadInt()
        {
            return int.Parse(ReadToken());
        }

        public static long ReadLong()
        {
            return long.Parse(ReadToken());
        }

        public static double ReadDouble()
        {
            return double.Parse(ReadToken(), CultureInfo.InvariantCulture);
        }

        public static int[] ReadIntArray()
        {
            return ReadAndSplitLine().Select(x => int.Parse(x)).ToArray();
        }

        public static long[] ReadLongArray()
        {
            return ReadAndSplitLine().Select(x => long.Parse(x)).ToArray();
        }

        public static double[] ReadDoubleArray()
        {
            return ReadAndSplitLine().Select(s => double.Parse(s, CultureInfo.InvariantCulture)).ToArray();
        }

        public static int[][] ReadIntMatrix(int numberOfRows)
        {
            int[][] matrix = new int[numberOfRows][];
            for (int i = 0; i < numberOfRows; i++)
                matrix[i] = ReadIntArray();
            return matrix;
        }

        public static int[][] ReadAndTransposeIntMatrix(int numberOfRows)
        {
            int[][] matrix = ReadIntMatrix(numberOfRows);
            int[][] ret = new int[matrix[0].Length][];
            for (int i = 0; i < ret.Length; i++)
            {
                ret[i] = new int[numberOfRows];
                for (int j = 0; j < numberOfRows; j++)
                    ret[i][j] = matrix[j][i];
            }
            return ret;
        }

        public static string[] ReadLines(int quantity)
        {
            string[] lines = new string[quantity];
            for (int i = 0; i < quantity; i++)
                lines[i] = reader.ReadLine().Trim();
            return lines;
        }

        public static void WriteArray<T>(params T[] array)
        {
            writer.WriteLine(string.Join(" ", array.Select(x => x.ToString()).ToArray()));
        }

        #endregion
    }
}
