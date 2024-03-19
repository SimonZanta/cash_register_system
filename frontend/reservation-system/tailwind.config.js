/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./pages/**/*.{js,ts,jsx,tsx,mdx}",
    "./components/**/*.{js,ts,jsx,tsx,mdx}",
    "./app/**/*.{js,ts,jsx,tsx,mdx}",
  ],
  theme: {
    extend: {
      colors: {
        'mainText' : '#FCFCFC',
        'mainBackground': '#141414',
        'secondaryBackground': '#111111',
        'secondary': '#8616B7'
      }
    },
    fontSize: {
      sm: '20px',
      base: '30px',
      lg: '50px',
      xl: '90px',
    }
  },
  plugins: [],
};
