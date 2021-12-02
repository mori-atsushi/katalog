const lightCodeTheme = require('prism-react-renderer/themes/github');
const darkCodeTheme = require('prism-react-renderer/themes/dracula');

/** @type {import('@docusaurus/types').DocusaurusConfig} */
module.exports = {
  title: 'Katalog - A UI Catalog Library made with Jetpack Compose',
  tagline: 'A UI Catalog Library made with Jetpack Compose',
  url: 'https://cyberagent-zemi.github.io/katalog',
  baseUrl: '/katalog/',
  onBrokenLinks: 'throw',
  onBrokenMarkdownLinks: 'warn',
  favicon: 'img/favicon.ico',
  organizationName: 'cyberagent-zemi',
  projectName: 'katalog',
  trailingSlash: false,
  themeConfig: {
    image: 'img/ogp.png',
    navbar: {
      title: 'Katalog',
      logo: {
        alt: 'Katalog Logo',
        src: 'img/logo.svg',
      },
      items: [
        {
          to: 'docs/getting-started',
          position: 'left',
          label: 'Getting Started',
        },
        {
          to: 'docs/main/register-and-start',
          activeBasePath: 'docs/main',
          position: 'left',
          label: 'Documentation',
        },
        {
          href: 'https://github.com/cyberagent-zemi/katalog',
          label: 'GitHub',
          position: 'right',
        },
      ],
    },
    footer: {
      style: 'dark',
      links: [
        {
          title: 'Docs',
          items: [
            {
              label: 'Getting Started',
              to: '/docs/getting-started',
            },
            {
              label: 'Documentation',
              to: '/docs/main/register-and-start',
            },
            {
              label: 'Extensions',
              to: '/docs/main/extensions/compose-theme',
            },
          ],
        },
        {
          title: 'More',
          items: [
            {
              label: 'GitHub',
              href: 'https://github.com/cyberagent-zemi/katalog',
            },
          ],
        },
      ],
      copyright: `Copyright © ${new Date().getFullYear()} Katalog. Built with Docusaurus.`,
    },
    prism: {
      theme: lightCodeTheme,
      darkTheme: darkCodeTheme,
      additionalLanguages: ['kotlin'],
    },
  },
  presets: [
    [
      '@docusaurus/preset-classic',
      {
        docs: {
          sidebarPath: require.resolve('./sidebars.js'),
          // Please change this to your repo.
          editUrl:
            'https://github.com/cyberagent-zemi/katalog/edit/main/docs/',
        },
        theme: {
          customCss: require.resolve('./src/css/custom.css'),
        },
      },
    ],
  ],
};
