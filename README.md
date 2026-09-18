# Gene Analyzer 🧬

GeneAnalyzer is a desktop application built with Java 17+ and JavaFX designed to help users analyze, visualize, and compare DNA sequences in a simple, intuitive interface.

-----------

Features

Sequence Analysis: Calculates sequence length, nucleotide counts (A, T, C, G), base percentages, and overall GC content.

Visualizations: Generates dynamic charts (bar charts, pie charts) and sequence representations for intuitive data analysis.

Sequence Comparison: Compares multiple DNA sequences side-by-side to highlight differences and similarities.

Data Export: Imports sequence files and exports formatted analysis results directly to CSV.

----------

Interface Preview

<img width="538" height="651" alt="スクリーンショット 2026-09-17 221509" src="https://github.com/user-attachments/assets/982e5e94-fa50-4252-952e-1086cb3bdf88" />

----------

Architecture & Pipeline

The application operates as a linear processing pipeline:  
import -> analyze -> compare -> export

Core Classes
	Data Containers:
  		DNASequence: Holds raw sequence strings and handles input validation.
  		NucleotideComposition: Stores counts and percentages for A, T, C, and G.
  		AnalysisResult: Bundles sequence metadata, composition, and GC content.
      
  Analysis & Comparison:
  		SequenceAnalyzer: Core engine that calculates composition and GC content.
  		SequenceComparator: Aggregates multiple sequences for comparison
      
  I/O:
   SequenceImporter: Reads sequence data from files into objects.
   CSVResultExporter: Writes compiled analysis results into CSV format.

-----------

Domain: Biological Data Analysis & Visualization
